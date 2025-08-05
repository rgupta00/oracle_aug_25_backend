package com.productapp.service;

import java.util.List;

import com.productapp.dto.Product;
import com.productapp.persitance.ProductRepository;
import com.productapp.persitance.impl.ProductRepositoryJdbc;

public class ProductServiceImpl implements ProductService {

	private ProductRepository productRepository;
	private ProductValidation productValidation;

	public ProductServiceImpl() {
		this.productRepository = new ProductRepositoryJdbc(); // :(
		this.productValidation = new ProductValidation();
	}

	@Override
	public void addProduct(Product product) {
		if (productValidation.valiation(product))
			productRepository.addProduct(product);
	}

	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
