package com.productapp.persitance;

import java.util.List;

import com.productapp.dto.Product;

public interface ProductRepository {
	public void addProduct(Product product);
	public List<Product> getAll();
}
