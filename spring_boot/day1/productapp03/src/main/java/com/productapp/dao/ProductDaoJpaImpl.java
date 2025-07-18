package com.productapp.dao;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;

//@Profile("prod")
@Repository(value = "jdbcJpa")
@Primary
public class ProductDaoJpaImpl implements ProductDao {

	private EntityManager em;
	
	@Autowired
	public ProductDaoJpaImpl(EntityManager em) {
		this.em = em;
	}

	@Override
	public List<Product> getAll() {
		return em.createQuery("select p from Product p", Product.class).getResultList();
	}

	@Override
	public Product getById(int productId) {
		return em.find(Product.class, productId);
	}

	@Override
	public Product addProduct(Product product) {
		em.merge(product);
		return product;
	}

	@Override
	public Product updateProduct(int productId, Product product) {
		Product productToUpdate=getById(productId);
		if(productToUpdate!=null) {
			productToUpdate.setPrice(product.getPrice());
			em.merge(productToUpdate);
		}
		return productToUpdate;
	}

	@Override
	public Product deleteProduct(int productId) {
		Product productToDelete=getById(productId);
		em.remove(productToDelete);
		return productToDelete;
	}

	
}
