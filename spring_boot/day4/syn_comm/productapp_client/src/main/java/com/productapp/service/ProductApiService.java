package com.productapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.productapp.models.Product;

@Service
public class ProductApiService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	//now we will call our api with the help of resttemplate
	public Product getById(int id) {
		return restTemplate
				.getForObject("http://localhost:9090/productapp/api/products/"+ id, Product.class);
	}
	
}
