package com.productapp.controller;

import com.productapp.repo.Product;
import com.productapp.service.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // vs @Controller
public class ProductController {
    private  ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //ResponseEntity =data + status code

    //get all products
    @GetMapping(path = "products")
    public ResponseEntity<List<Product>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(productService.getAll());
    }
    //get by id
    @GetMapping(path = "products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id){
        return ResponseEntity.ok(productService.getProductById(id));
    }
    //adding a product
    @PostMapping(path = "products")
    public ResponseEntity<Product> addProduct( @RequestBody Product product){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.addProduct(product));
    }

    //delete
    @DeleteMapping(path = "products/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable(name = "id") int id){
         productService.deleteProduct(id);
         return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    //update
    @PutMapping(path = "products/{id}")
    public ResponseEntity<Product>  updateProduct(@PathVariable(name = "id") int id, @RequestBody Product product){
        return ResponseEntity.ok(productService.updateProduct(id, product));
    }

}
