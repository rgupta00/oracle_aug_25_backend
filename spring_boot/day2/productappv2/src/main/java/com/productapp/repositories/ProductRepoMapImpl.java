package com.productapp.repositories;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.productapp.models.Product;

@Repository
public class ProductRepoMapImpl implements ProductRepo {
	private static Map<Integer, Product> map;
	private static int counter=0;
	
	static{
		map=new HashMap<>();
		map.put(++counter, new Product(counter, "laptop", BigDecimal.valueOf(200000)));
		map.put(++counter, new Product(counter, "laptop cover", BigDecimal.valueOf(200)));
	}
	
	@Override
	public List<Product> getAll() {
		return new LinkedList<>(map.values());
	}

	@Override
	public Product addProduct(Product product) {
		// TODO Auto-generated method stub
		return null;
	}
}



