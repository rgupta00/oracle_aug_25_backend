package com.productapp.service;

import java.util.List;

import com.productapp.dao.Product;

public interface ProductService {
	public List<Product> getAll();
	
	public Product getById(int productId);
	
	public Product addProduct(Product product);
	public Product updateProduct(int productId, Product product);
	public Product deleteProduct(int productId);
	
}
