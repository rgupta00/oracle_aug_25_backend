package main2;

import java.util.*;

public class Demo {
	public static void main(String[] args) {
		ArrayList<Customer>customers=new ArrayList<>();
		while(true) {
			Customer customer=new Customer("foo");
			customers.add(customer);
			if(customers.size()>10000) {
				for(int i=0;i<5000;i++) {
					customers.remove(0);
				}
			}
		}
	}

}
