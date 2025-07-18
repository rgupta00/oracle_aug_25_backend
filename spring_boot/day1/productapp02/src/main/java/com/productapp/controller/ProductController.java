package com.productapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.dao.Product;
import com.productapp.service.ProductService;

@RestController
@RequestMapping(path="api")
public class ProductController {
	
	private ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	//get all products
	@GetMapping(path = "products")
	public List<Product>getAll(){
		return productService.getAll();
	}
	
	//get by id
	@GetMapping(path = "products/{productId}")
	public Product getById(@PathVariable(name="productId")  int productId) {
		return productService.getById(productId);
	}
	
	//add product
	@PostMapping(path = "products")
	public Product addProduct(@RequestBody Product product) {
		return productService.addProduct(product);
	}
	
	//update product
	@PutMapping(path = "products/{productId}")
	public Product updateById(@PathVariable(name="productId")  int productId, 
			@RequestBody Product product) {
		return productService.updateProduct(productId, product);
	}
	
	//delete product
	@DeleteMapping(path = "products/{productId}")
	public Product deleteById(@PathVariable(name="productId")  int productId) {
		return productService.deleteProduct(productId);
	}
}










