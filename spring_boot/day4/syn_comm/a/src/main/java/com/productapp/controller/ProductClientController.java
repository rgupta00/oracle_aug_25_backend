package com.productapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.dto.Product;
import com.productapp.service.ProductClientService;

@RestController
public class ProductClientController {

	@Autowired
	private ProductClientService productClientService;
	
	@GetMapping(path="productsclient/{id}")
	public Product getById(@PathVariable int id) {
		return productClientService.getByIdByRemoteService(id);
	}
	
}
