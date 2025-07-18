package com.productapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	//ResponseEntity =data + status code
	//get all products
	@GetMapping(path = "products")
	public ResponseEntity<List<Product>> getAll(){
		return ResponseEntity.ok(productService.getAll());
	}
	
	//get by id
	@GetMapping(path = "products/{productId}")
	public ResponseEntity<Product> getById(@PathVariable(name="productId")  int productId) {
		return ResponseEntity.status(HttpStatus.OK).body(productService.getById(productId));
	}
	
	//add product
	@PostMapping(path = "products")
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		return ResponseEntity.status(HttpStatus.CREATED).body(productService.addProduct(product));
	}
	
	//update product
	@PutMapping(path = "products/{productId}")
	public ResponseEntity<Product> updateById(@PathVariable(name="productId")  int productId, 
			@RequestBody Product product) {
		return ResponseEntity.ok(productService.updateProduct(productId, product));
	}
	
	//delete product
	@DeleteMapping(path = "products/{productId}")
	public ResponseEntity<Void> deleteById(@PathVariable(name="productId")  int productId) {
		 productService.deleteProduct(productId);
		 
		 return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}










