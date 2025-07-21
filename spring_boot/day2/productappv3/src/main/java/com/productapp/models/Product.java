package com.productapp.models;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data

@NoArgsConstructor
@Builder
@AllArgsConstructor

@Entity
@Table(name="product_table")
public class Product {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;
	private String productName;
	private BigDecimal productPrice;
	
	public Product(String productName, BigDecimal productPrice) {
		this.productName = productName;
		this.productPrice = productPrice;
	}
	
	
}
