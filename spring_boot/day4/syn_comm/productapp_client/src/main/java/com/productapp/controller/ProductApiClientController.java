package com.productapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.models.Product;
import com.productapp.service.ProductApiService;

@RestController
public class ProductApiClientController {
	
	@Autowired
	private ProductApiService productApiService;
	
	@GetMapping(path = "productclient/{id}")
	public Product getProduct(@PathVariable int id) {
		return productApiService.getById(id);
	}
	
}
