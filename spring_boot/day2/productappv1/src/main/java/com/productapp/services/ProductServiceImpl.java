package com.productapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productapp.models.Product;
import com.productapp.repositories.ProductRepo;
//Service layer =BL + CCC**
@Service
public class ProductServiceImpl implements ProductService {

	private ProductRepo productRepo;
	
	@Autowired
	public ProductServiceImpl(ProductRepo productRepo) {
		this.productRepo = productRepo;
	}

	@Override
	public List<Product> getAll() {
		return productRepo.getAll();
	}

}
