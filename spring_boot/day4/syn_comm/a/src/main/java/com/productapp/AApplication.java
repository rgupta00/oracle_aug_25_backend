package com.productapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableFeignClients("com.productapp.proxyservice")

@SpringBootApplication
public class AApplication {

	public static void main(String[] args) {
		SpringApplication.run(AApplication.class, args);
	}
	//now we will configre resttemplate
	//spring container : bean @Component vs @Bean
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
