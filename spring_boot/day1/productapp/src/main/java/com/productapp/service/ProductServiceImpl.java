package com.productapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.productapp.dao.Product;
import com.productapp.dao.ProductDao;
/*
 * <bean id="productService"
		class="com.productapp.service.ProductServiceImpl">
		<property name="productDao" ref="dao"/>
	</bean>
 */
@Service(value = "productService")
public class ProductServiceImpl implements ProductService {

	private ProductDao productDao;
	
	@Autowired
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	//ctr
	public ProductServiceImpl(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	public List<Product> getAll() {
		return productDao.getAll();
	}

}
