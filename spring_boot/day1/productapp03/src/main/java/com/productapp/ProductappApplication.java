package com.productapp;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.productapp.dao.Product;
import com.productapp.service.ProductService;

import jakarta.persistence.EntityManager;

@SpringBootApplication
public class ProductappApplication implements CommandLineRunner{

	@Autowired
	private ProductService productService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(ProductappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("-------------------------------");
		//productService.addProduct(new Product("latop", BigDecimal.valueOf(200000)));
	}

}
