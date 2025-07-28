package com.empapp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.empapp.entities.Employee;
import com.empapp.service.EmployeeService;
@CrossOrigin
@RestController
public class EmployeeController {
	
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	//http://localhost:8080/employees
	//get all
	@GetMapping(path="employees")
	public List<Employee> getAll(){
		return employeeService.getAll();
	}
	
	@GetMapping(path = "employees/{id}")
	public Employee findById(@PathVariable(name = "id") int id){
		return employeeService.getById(id);
	}
	
	@PostMapping(path = "employees")
	public Employee addEmployee( @RequestBody Employee employee){
		return employeeService.addEmployee(employee);
	}
	
	@DeleteMapping(path = "employees/{id}")
	public Employee deleteEmployee(@PathVariable(name = "id") int id){
		return employeeService.deleteEmployee(id);
	}
	
	@PutMapping(path = "employees/{id}")
	public Employee updateEmployee(@PathVariable(name = "id") int id, @RequestBody Employee employee){
		return employeeService.updateEmployee(id, employee);
	}

}
