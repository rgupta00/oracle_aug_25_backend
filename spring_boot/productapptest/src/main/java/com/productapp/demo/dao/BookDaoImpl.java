package com.productapp.demo.dao;

import java.util.Arrays;
import java.util.List;

public class BookDaoImpl implements BookDao{

	@Override
	public List<String> getBooks() {
		System.out.println("is this method id called?");
		return Arrays.asList("java","effective java","modern physics");
	}

}
