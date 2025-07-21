package com.productapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.productapp.models.Product;
import com.productapp.repositories.ProductRepo;
//Service layer =BL + CCC**
@Service
@Transactional //acid explict tx mgt :( hibernate jpa

				// declative implict tx mgt : @Transactional

public class ProductServiceImpl implements ProductService {
	
	private ProductRepo productRepo;
	
	@Autowired
	public ProductServiceImpl(ProductRepo productRepo) {
		this.productRepo = productRepo;
	}

	@Override
	public List<Product> getAll() {
		return productRepo.findAll();
	}

	@Override
	public Product addProduct(Product product) {
		productRepo.save(product);
		
		return product;
	}

}
