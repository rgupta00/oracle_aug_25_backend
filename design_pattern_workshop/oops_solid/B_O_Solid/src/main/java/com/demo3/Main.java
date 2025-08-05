package com.demo3;
import java.util.*;
import java.util.function.Predicate;
public class Main {

	public static void main(String[] args) {
		//public Book(String isbn, String title, String author, double price)
		List<Book> books=Arrays.asList(
				new Book("1212", "java effective", "foo", 200),
				new Book("129", "power of subconsious mind", "foo", 600)
				);
	
//		List<Book> javaBooks=BookService
//				.getBooksOnCondition(books, b-> b.getTitle().contains("java"));
//		
//		javaBooks.forEach(b-> System.out.println(b));
		
//		List<Book> costlyBooks=BookService
//				.getBooksOnCondition(books, b-> b.getPrice()>=300);
//		
//		costlyBooks.forEach(b-> System.out.println(b));
		
		
		Predicate<Book> costlyBookPredicate= b->b.getPrice()>=300;
		Predicate<Book> javaBookPredicate= b->b.getTitle().contains("java");
		
		List<Book> costlyBooks=BookService
				.getBooksOnCondition(books, costlyBookPredicate.or(javaBookPredicate));
		
		costlyBooks.forEach(b-> System.out.println(b));
		
	}
}
