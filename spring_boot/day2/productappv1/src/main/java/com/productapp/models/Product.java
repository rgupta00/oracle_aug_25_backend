package com.productapp.models;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Product {
	private int productId;
	private String productName;
	private BigDecimal productPrice;
}
