package com.baseit.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.baseit.models.Product;
import com.baseit.service.*;

@Controller
public class HomeController {

	@Autowired
	CrudService<Product, Integer> crudDao;

	@RequestMapping("/")
	public String home() {
		return "home";
	}

	@RequestMapping("/product")
	public String product(Model model) {
		List<Product> products = crudDao.getLists();
		model.addAttribute("products", products);
		return "product";
	}

	@RequestMapping("/product/{product_id}")
	private String viewproduct(@PathVariable int product_id, Model model) throws IOException {
		Product product = crudDao.getById(product_id);
		model.addAttribute(product);
		return "viewproduct";

	}

}
