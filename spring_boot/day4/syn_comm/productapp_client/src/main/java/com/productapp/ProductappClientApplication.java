package com.productapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ProductappClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductappClientApplication.class, args);
	}

	//i have to define a bean for RestTemplate (infra str)
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
