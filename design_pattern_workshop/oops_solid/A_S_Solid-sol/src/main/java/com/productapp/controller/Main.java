package com.productapp.controller;

import java.sql.SQLException;

import com.productapp.dto.Product;
import com.productapp.service.ProductService;
import com.productapp.service.ProductServiceImpl;

public class Main {

	public static void main(String[] args) throws SQLException {
		ProductService productService=new ProductServiceImpl();
		
		productService.addProduct(new Product("pen", 120));
		System.out.println("--------------");
	}
}
