package com.empapp.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.empapp.entities.Employee;
import com.empapp.exceptions.EmployeeNotFoundException;
import com.empapp.repo.EmployeeRepo;
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeRepo employeeRepo;
	
	public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
		this.employeeRepo = employeeRepo;
	}

	@Override
	public List<Employee> getAll() {
		return employeeRepo.findAll();
	}

	@Override
	public Employee getById(int id) {
		return employeeRepo.findById(id).orElseThrow(()-> new EmployeeNotFoundException("emp with id "+ id +" is not found"));
	}

	@Override
	public Employee updateEmployee(int id, Employee employee) {
		Employee empToUpdate=getById(id);
		empToUpdate.setSalary(employee.getSalary());
		employeeRepo.save(empToUpdate);
		return empToUpdate;
	}

	@Override
	public Employee deleteEmployee(int id) {
		Employee empToDelete=getById(id);
		employeeRepo.delete(empToDelete);
		return empToDelete;
	}

	@Override
	public Employee addEmployee(Employee employee) {
		employeeRepo.save(employee);
		return employee;
	}

}
