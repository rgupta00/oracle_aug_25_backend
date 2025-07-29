package com.productapp.demo.calapp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {

	private Calculator calculator;
	
	@BeforeEach
	public void beforeEachTest() {
		calculator=new Calculator();
	}
	
	@Test
	public void addTest() {	
		int sum=calculator.add(1,2);
		assertEquals(3, sum);
	}
	
	@Test
	public void addMultiply() {
		int mul=calculator.mul(2,5);
		assertEquals(10, mul);
	}

	@Test
	public void divideTestPostive() {
		int divide= calculator.divide(12, 2);
		assertEquals(6, divide);
		
	}
	@Test
	public void divideTestWithExcetion() {
		assertThrows(ArithmeticException.class, ()-> calculator.divide(12, 0),"divide by zero");
	}
	
	
	@AfterEach
	public void afterEachTest() {
		calculator=null;
	}
}











