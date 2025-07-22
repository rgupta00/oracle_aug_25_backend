package com.productapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.productapp.dao.ProductDao;
import com.productapp.dao.ProductDaoMapImpl;
import com.productapp.service.ProductService;
import com.productapp.service.ProductServiceImpl;

@Configuration // <context:annotation-config/>
@ComponentScan(basePackages = "com.productapp")
final public class AppConfig {
	@Bean
	ProductService foo(ProductDao productDao) {
		System.out.println("------------------------");
		return new ProductServiceImpl(productDao);
	}

	@Bean
	ProductDao getProductDao() {
		return new ProductDaoMapImpl();
	}
}
