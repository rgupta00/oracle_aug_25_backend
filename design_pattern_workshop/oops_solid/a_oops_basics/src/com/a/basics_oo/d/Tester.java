package com.a.basics_oo.d;

public class Tester {

	public static void main(String[] args) {
		


		
		Employee employee=new PartTimeEmployee(1, "amit", 3000, 23, 5600);
		//System.out.println(employee);
		
		EmployeePaymentProceseingSystem.paymentProcessingSystem(employee);
	}

}
