package com.empapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.empapp.repo.Employee;
import com.empapp.repo.EmployeeRepo;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

	@Autowired
	private EmployeeRepo employeeRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		employeeRepo.save(new Employee("raj", 56000.00));
		employeeRepo.save(new Employee("rajiv", 56000.00));
		employeeRepo.save(new Employee("rajesh", 56000.00));
		employeeRepo.save(new Employee("ekta", 56000.00));
		employeeRepo.save(new Employee("keshav", 56000.00));
		employeeRepo.save(new Employee("gun", 56000.00));
		employeeRepo.save(new Employee("gunika", 56000.00));
		
		
		
	}

}
