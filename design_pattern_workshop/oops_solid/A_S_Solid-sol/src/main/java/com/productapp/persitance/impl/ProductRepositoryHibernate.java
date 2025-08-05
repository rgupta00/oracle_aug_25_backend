package com.productapp.persitance.impl;

import java.util.List;

import org.hibernate.HibernateException;

import com.productapp.dto.Product;
import com.productapp.exceptions.DataAccessException;
import com.productapp.persitance.ProductRepository;

public class ProductRepositoryHibernate implements ProductRepository{

	@Override
	public void addProduct(Product product) {
		/// some hibernate
		try {
			if(1==1)
				throw new HibernateException("some hib ex");
		}catch(HibernateException ex) {
			throw new DataAccessException(ex.getMessage());
		}
	}

	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
