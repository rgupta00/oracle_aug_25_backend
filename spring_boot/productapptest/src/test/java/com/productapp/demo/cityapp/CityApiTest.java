package com.productapp.demo.cityapp;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CityApiTest {

	private CityApi api;
	@BeforeEach
	void setUp() throws Exception {
		api=new CityApi();
	}


	@Test
	void testGetCity() {
		Assertions.assertTimeout(Duration.ofMillis(1500), ()->api.getCity(33));
	}
	
	@AfterEach
	void tearDown() throws Exception {
		api=null;
	}
}











