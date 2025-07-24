package com.productapp.proxyservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.productapp.dto.Product;
@FeignClient(url="http://localhost:8081", name = "product-client")
public interface ProductProxyService {
	
	@GetMapping(path="products/{id}")
	public Product getById(@PathVariable int id) ;
	
	//
}
