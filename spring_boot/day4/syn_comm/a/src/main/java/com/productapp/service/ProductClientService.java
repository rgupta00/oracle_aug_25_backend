package com.productapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.productapp.dto.Product;
import com.productapp.proxyservice.ProductProxyService;

@Service
public class ProductClientService {
	
	@Autowired
	private ProductProxyService productProxyService;
	
	public Product getByIdByRemoteService(int id) {
		return productProxyService.getById(id);
	}


//	@Autowired
//	private RestTemplate restTemplate;
//	
//	public Product getByIdByRemoteService(int id) {
//		Product product=restTemplate
//				.getForObject("http://localhost:8081/products/"+id, Product.class);
//		return product;
//	}

}
