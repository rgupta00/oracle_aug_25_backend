package com.bankapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.dto.DataDto;

@RestController
public class HelloController {
	
	@Autowired
	private DataDto dataDto;
	
	
	@GetMapping(path="getdata")
	public DataDto getDataDto() {
		return dataDto;
	}
}
