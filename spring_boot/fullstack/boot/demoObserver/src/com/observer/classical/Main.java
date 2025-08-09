package com.observer.classical;

public class Main {

	public static void main(String[] args) {
		Stock stock=new Stock();
		stock.addObserver(new Investor("yesh"));
		stock.addObserver(new Investor("amit"));
		
		stock.setPrice(40);
		
	}
}
