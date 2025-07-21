package com.productapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.productapp.models.Product;
@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
	//@Query anntation 
	//gen quaries
	public List<Product> findByProductName(String productName);
}
