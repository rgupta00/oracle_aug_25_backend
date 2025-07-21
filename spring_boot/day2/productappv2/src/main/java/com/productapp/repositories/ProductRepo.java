package com.productapp.repositories;

import java.util.List;

import com.productapp.models.Product;

public interface ProductRepo {
	public List<Product> getAll();
	public Product addProduct(Product product);
}
