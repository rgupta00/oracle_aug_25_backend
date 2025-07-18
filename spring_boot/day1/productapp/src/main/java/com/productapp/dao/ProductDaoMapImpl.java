package com.productapp.dao;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
@Repository(value = "mapDao")
//@Primary
@Profile("test")
public class ProductDaoMapImpl implements ProductDao{

	private static Map<Integer, Product> map=new HashMap<>();
	private static int counter=0;
	
	static {
		map.put(++counter, new Product(counter, "laptop", BigDecimal.valueOf(120000)));
		map.put(++counter, new Product(counter, "laptop stand", BigDecimal.valueOf(1200)));
	}
	@Override
	public List<Product> getAll() {
		System.out.println("get all product using map");
		return new LinkedList<>(map.values());
	}
}
