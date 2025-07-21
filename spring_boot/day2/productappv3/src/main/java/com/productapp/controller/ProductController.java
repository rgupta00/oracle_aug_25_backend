package com.productapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.models.Product;
import com.productapp.services.ProductService;

@RestController
@RequestMapping(path="api")
public class ProductController {
	
	private ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	//get all products
	@GetMapping(path = "products")
	public List<Product> getAllProducts(){
		return productService.getAll();
	}
	@PostMapping(path = "products")
	public Product addProduct(@RequestBody Product product) {
		return productService.addProduct(product);
	}

}
