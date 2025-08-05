package com.empapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.empapp.repo.EmployeeRepo;
@CrossOrigin("*")
@RestController
public class EmployeeController {

	@Autowired
	private EmployeeRepo employeeRepo;
	
	@GetMapping(path = "employees")
	public String hello(@RequestParam(name = "name") String name) {
		System.out.println("hello ..." + name);
		return "hello " + name;
	}
}
