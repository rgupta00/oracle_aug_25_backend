package com.productapp.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {

	@Value("${app.info}")
	private String info;
	
	@GetMapping(path="profile")
	public String sayHello() {
		return info;
	}
}
