package com.productapp.dao;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

//@Profile("prod")
@Repository(value = "jdbcDao")
public class ProductDaoJdbcImpl implements ProductDao {

	private static Map<Integer, Product> map = new HashMap<>();
	private static int counter = 0;

	static {
		map.put(++counter, new Product(counter, "laptop", BigDecimal.valueOf(120000)));
		map.put(++counter, new Product(counter, "laptop stand", BigDecimal.valueOf(1200)));
	}

	@Override
	public List<Product> getAll() {
		System.out.println("get all product using jdbc");
		return new LinkedList<>(map.values());
	}

	@Override
	public Product getById(int productId) {
		return map.get(productId);
	}

	@Override
	public Product addProduct(Product product) {
		product.setId(++counter);
		map.put(counter, product);

		return product;
	}

	@Override
	public Product updateProduct(int productId, Product product) {
		Product productToUpdate = getById(productId);
		if (productToUpdate != null) {
			productToUpdate.setPrice(product.getPrice());
			map.put(productToUpdate.getId(), productToUpdate);

		}
		return productToUpdate;
	}

	@Override
	public Product deleteProduct(int productId) {
		Product productToDelete = getById(productId);
		if (productToDelete != null)
			map.remove(productId);
		return productToDelete;
	}
}
