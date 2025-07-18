package com.productapp.dao;

import java.util.List;

public interface ProductDao {
	public List<Product> getAll();
	
	public Product getById(int productId);
	
	public Product addProduct(Product product);
	public Product updateProduct(int productId, Product product);
	public Product deleteProduct(int productId);
	
}
