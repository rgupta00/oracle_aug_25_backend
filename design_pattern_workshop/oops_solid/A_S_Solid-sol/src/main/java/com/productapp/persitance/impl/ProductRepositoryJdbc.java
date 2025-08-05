package com.productapp.persitance.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.productapp.dto.Product;
import com.productapp.exceptions.DataAccessException;
import com.productapp.factories.JdbcConnectionFactory;
import com.productapp.persitance.ProductRepository;

public class ProductRepositoryJdbc implements ProductRepository{

	private Connection connection;
	
	
	
	public ProductRepositoryJdbc() {
		connection=JdbcConnectionFactory.getConnection();
	}

	@Override
	public void addProduct(Product product) {
		try {
			PreparedStatement pstmt = 
					connection.prepareStatement("insert into product(name,price) values(?,?)");
			
			pstmt.setString(1, product.getName());
			pstmt.setDouble(2, product.getPrice());

			pstmt.executeUpdate();
			System.out.println("adding product to db using jdbc..");
			
		}catch(SQLException ex) {
			//log4j2 the error
			throw new DataAccessException(ex.getMessage());
		}
	}

	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
