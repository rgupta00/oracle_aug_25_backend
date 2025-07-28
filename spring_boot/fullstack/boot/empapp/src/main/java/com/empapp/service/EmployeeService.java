package com.empapp.service;

import java.util.List;

import com.empapp.entities.Employee;

public interface EmployeeService {
	public List<Employee> getAll();
	public Employee getById(int id);
	public Employee addEmployee(Employee employee);
	public Employee updateEmployee(int id, Employee employee);
	public Employee deleteEmployee(int id);
}
