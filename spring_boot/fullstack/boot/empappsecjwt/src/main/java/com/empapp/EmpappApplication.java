package com.empapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.empapp.entities.Employee;
import com.empapp.repo.EmployeeRepo;

@SpringBootApplication
public class EmpappApplication implements CommandLineRunner{

	@Autowired
	private EmployeeRepo employeeRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(EmpappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		employeeRepo.save(new Employee("ekta", 56000.00));
		employeeRepo.save(new Employee("rajeev", 56000.00));
	}

}
