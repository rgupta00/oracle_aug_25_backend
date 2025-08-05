package com.demo3;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

 public class BookService {
	
	//OCP
	//behaviural parametrization 
	//change is the only constant in life
	public static  List<Book> getBooksOnCondition(List<Book> books, Predicate<Book> predicate){
		return books.stream().filter(predicate).collect(Collectors.toList());
	}
	
	
}
