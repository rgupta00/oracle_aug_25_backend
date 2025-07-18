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
//@Profile("dev")
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
	
	@Override
	public Product getById(int productId) {
		System.out.println("get byid product using map");
		return map.get(productId);
	}

	@Override
	public Product addProduct(Product product) {
		System.out.println("addProduct product using map");
		product.setId(++counter);
		map.put(counter, product);

		return product;
	}

	@Override
	public Product updateProduct(int productId, Product product) {
		System.out.println("updateProduct product using map");
		Product productToUpdate = getById(productId);
		if (productToUpdate != null) {
			productToUpdate.setPrice(product.getPrice());
			map.put(productToUpdate.getId(), productToUpdate);

		}
		return productToUpdate;
	}

	@Override
	public Product deleteProduct(int productId) {
		System.out.println("deleteProduct product using map");
		Product productToDelete = getById(productId);
		if (productToDelete != null)
			map.remove(productId);
		return productToDelete;
	}
}
