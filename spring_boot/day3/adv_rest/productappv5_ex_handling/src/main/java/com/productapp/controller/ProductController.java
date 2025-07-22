package com.productapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.models.Product;
import com.productapp.services.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "api")
public class ProductController {

	private ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	// get all products
	@GetMapping(path = "products", produces = { MediaType.APPLICATION_JSON_VALUE, 
											MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<Product>> getAllProducts() {
		return ResponseEntity.ok(productService.getAll());
	}

	// hey parser u will populate data into the object but before it just check is
	// validation is resp or not
	// MethodArgumentNotValidException

	@PostMapping(path = "products")
	public ResponseEntity<Product> addProduct(@Valid @RequestBody Product product) {
		return ResponseEntity.status(HttpStatus.CREATED).body(productService.addProduct(product));
	}

	// get by product name
	@GetMapping(path = "productsbyname/{productName}")
	public ResponseEntity<List<Product>> getAllProductsByName(@PathVariable String productName) {
		return ResponseEntity.status(HttpStatus.OK).body(productService.getProductByName(productName));
	}

	// get product by id
	@GetMapping(path = "products/{productId}")
	public ResponseEntity<Product> getProductById(@PathVariable int productId) {

		return ResponseEntity.ok(productService.getById(productId));
	}

	// delete by id

	@DeleteMapping(path = "products/{productId}")
	public ResponseEntity<Void> deleteProductById(@PathVariable int productId) {
		productService.deleteById(productId);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	// update
	@PutMapping(path = "products/{productId}")
	public ResponseEntity<Product> updateProduct(@PathVariable int productId, @Valid @RequestBody Product product) {
		return ResponseEntity.ok(productService.update(productId, product));
	}
}
