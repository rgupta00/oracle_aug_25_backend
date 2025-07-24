package com.productapp.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.productapp.dto.Product;

@Service
public class ProductService {
	
	public Product getById(int id) {
		return new Product(id, "laptop", BigDecimal.valueOf(12000));
	}
}
