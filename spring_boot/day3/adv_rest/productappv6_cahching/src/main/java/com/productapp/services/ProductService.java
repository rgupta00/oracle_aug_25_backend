package com.productapp.services;

import java.util.List;

import com.productapp.models.Product;

public interface ProductService {
	public List<Product> getAll();
	
	public List<Product> getProductByName(String productName);
	
	public Product addProduct(Product product);
	
	public Product getById(int productId);
	
	public Product deleteById(int productId);
	
	public Product update(int productId, Product product);
	
	public void invalidate();
}
