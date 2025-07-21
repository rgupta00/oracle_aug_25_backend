package com.productapp.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.productapp.models.Product;

import jakarta.persistence.EntityManager;
@Repository
@Primary
public class ProductRepoJpaImpl implements ProductRepo {

	private EntityManager entityManager;
	
	@Autowired
	public ProductRepoJpaImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}


	@Override
	public List<Product> getAll() {
		return entityManager
				.createQuery("select p from Product p", Product.class)
				.getResultList();
	}


	@Override
	public Product addProduct(Product product) {
		entityManager.persist(product);
		return product;
	}

}
