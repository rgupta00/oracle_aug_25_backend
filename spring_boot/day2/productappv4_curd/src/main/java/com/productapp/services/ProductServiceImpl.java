package com.productapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.productapp.exceptions.ProductNotFoundException;
import com.productapp.models.Product;
import com.productapp.repositories.ProductRepo;
//Service layer =BL + CCC**
@Service
@Transactional 

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

	@Override
	public List<Product> getProductByName(String productName) {
		return productRepo.findByProductName(productName);
	}

	@Override
	public Product getById(int productId) {
		return productRepo.findById(productId)
				.orElseThrow(()-> new ProductNotFoundException("product not found"));
				
	}

	@Override
	public Product deleteById(int productId) {
		Product productToDelete= getById(productId);
		productRepo.delete(productToDelete);
		
		return productToDelete;
	}

	@Override
	public Product update(int productId, Product product) {
		Product productToUpdate= getById(productId);
		
		productToUpdate.setProductPrice(product.getProductPrice());
		
		productRepo.save(productToUpdate);
		
		return productToUpdate;
	}

}
