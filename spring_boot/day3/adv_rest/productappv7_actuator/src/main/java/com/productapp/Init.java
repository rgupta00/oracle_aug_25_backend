package com.productapp;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.productapp.models.Product;
import com.productapp.repositories.ProductRepo;
import com.productapp.services.ProductService;

import jakarta.persistence.EntityManager;

@Component
public class Init implements CommandLineRunner {
	@Autowired
	private EntityManager em;

	@Autowired
	private ProductService productService;

	@Override
	public void run(String... args) throws Exception {
		// if u want to run some code that must run after spring boot succesfull started
		System.out.println("---------------------------------------------");
		if (em != null) {
			System.out.println("-------em is created---------------");
		}
//		productService.addProduct(new Product("laptop", BigDecimal.valueOf(200000)));
//
//		productService.addProduct(new Product("laptop stand db", BigDecimal.valueOf(200)));
	}
}
