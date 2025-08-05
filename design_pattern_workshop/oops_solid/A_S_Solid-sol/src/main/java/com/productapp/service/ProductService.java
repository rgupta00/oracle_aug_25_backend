package com.productapp.service;

import java.util.List;

import com.productapp.dto.Product;

public interface ProductService {
	public void addProduct(Product product);
	public List<Product> getAll();
}
