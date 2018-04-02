package com.baseit.controllers;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.baseit.models.Product;
import com.baseit.service.*;

@Controller
public class AdminController {

	private Path path;

	
	@Autowired
	CrudService<Product, Integer> crudDao;

	@RequestMapping("/admin")
	public String admin() {
		return "admin";
	}

	@RequestMapping("/admin/inventory")
	public String inventory(Model model) {
		List<Product> products = crudDao.getLists();
		model.addAttribute("products", products);
		return "inventory";
	}

	@RequestMapping("/admin/product/add")
	public String addProduct(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		return "add_product";
	}

	@RequestMapping(value = "/admin/product/add", method = RequestMethod.POST)
	public String add(@Valid @ModelAttribute("product") Product product, BindingResult result,
			HttpServletRequest request) {
		if (result.hasErrors()) {
			return "add_product";
		}
		crudDao.add(product);

		MultipartFile productImage = product.getProduct_image();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\" + product.getProduct_id() + ".png");

		if (productImage != null && !productImage.isEmpty()) {
			try {
				productImage.transferTo(new File(path.toString()));
			} catch (Exception ex) {
				ex.printStackTrace();
				throw new RuntimeException("Product image saving failed", ex);
			}
		}

		return "redirect:/admin/inventory";
	}

	@RequestMapping("/admin/product/delete/{id}")
	public String deleteProduct(@PathVariable int id, Model model, HttpServletRequest request) {

		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\" + id + ".png");

		if (Files.exists(path)) {
			try {
				Files.delete(path);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		crudDao.delete(id);
		return "redirect:/admin/inventory";
	}

	@RequestMapping("/admin/product/edit/{id}")
	public String editProduct(@PathVariable("id") int id, Model model) {
		Product product = crudDao.getById(id);
		model.addAttribute("product", product);
		return "edit_product";
	}

	@RequestMapping(value = "/admin/product/edit", method = RequestMethod.POST)
	public String editProductPost(@Valid @ModelAttribute("product") Product product, BindingResult result,
			HttpServletRequest request) {

		if (result.hasErrors()) {
			return "edit_product";
		}

		crudDao.edit(product);

		MultipartFile productImage = product.getProduct_image();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory + "/WEB-INF/resources/images/" + product.getProduct_id() + ".png");

		if (productImage != null && !productImage.isEmpty()) {
			try {
				productImage.transferTo(new File(path.toString()));
			} catch (Exception ex) {
				ex.printStackTrace();
				throw new RuntimeException("Product image saving failed", ex);
			}
		}
		return "redirect:/admin/inventory";
	}
}
