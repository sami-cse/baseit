package com.baseit.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int product_id;

	@NotEmpty(message = "Product Name Must Not Be Null")
	private String product_name;

	@Min(value = 0, message = "Product Price Must Not Be Less Than Zero")
	private float product_price;

	@Transient
	private MultipartFile product_image;

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public float getProduct_price() {
		return product_price;
	}

	public void setProduct_price(float product_price) {
		this.product_price = product_price;
	}

	public MultipartFile getProduct_image() {
		return product_image;
	}

	public void setProduct_image(MultipartFile product_image) {
		this.product_image = product_image;
	}

}
