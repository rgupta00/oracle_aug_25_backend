package com.productapp;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.productapp.dao.Product;
import com.productapp.dao.ProductDao;
import com.productapp.dao.ProductDaoJdbcImpl;
import com.productapp.dao.ProductDaoMapImpl;
import com.productapp.service.ProductService;
import com.productapp.service.ProductServiceImpl;

public class Demo {

	public static void main(String[] args) {

		ApplicationContext ctx= 
				new AnnotationConfigApplicationContext(AppConfig.class);
	
		ProductService productService= (ProductService) 
				ctx.getBean("foo");
		
		List<Product> products=productService.getAll();
		
		products.forEach(p-> System.out.println(p));
		
		ProductService productService2= (ProductService) 
				ctx.getBean("foo");
		
		
		
			
	}
}







