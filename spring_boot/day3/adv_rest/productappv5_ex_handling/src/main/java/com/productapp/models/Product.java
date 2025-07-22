package com.productapp.models;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.Range;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
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
	
	@NotNull(message = "{product.productName.absent}")
	private String productName;
	
	@NotNull(message = "{product.productPrice.absent}")
	@Range(min=10, max = 3000000, message = "productPrice should be within the range")
	private BigDecimal productPrice;
	
	
	public Product(String productName, BigDecimal productPrice) {
		this.productName = productName;
		this.productPrice = productPrice;
	}
	
	
}
