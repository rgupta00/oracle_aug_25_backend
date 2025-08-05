package com.empapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.empapp.config.JwtService;
import com.empapp.dto.AuthRequest;
import com.empapp.dto.AuthResponse;
import com.empapp.dto.JwtResponse;
import com.empapp.entities.Employee;
import com.empapp.service.EmployeeService;
@CrossOrigin
@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

   
	
    @PostMapping(path = "authenticate")
    public ResponseEntity<?>  authenticateAndGetToken(@RequestBody AuthRequest authRequest) {

        Authentication authentication
                =authenticationManager.
                authenticate(new UsernamePasswordAuthenticationToken(
                        authRequest.getUsername(),
                        authRequest.getPassword()
                ));

        if(authentication.isAuthenticated()){
        	String token=jwtService.generateToken(authRequest.getUsername());
        	return ResponseEntity.ok(new JwtResponse(token));
        }else {
            throw  new UsernameNotFoundException("user is invalid");
        }
    }
	
	@GetMapping(path="validateLogin")
	public AuthResponse validateLogin() {
			return new AuthResponse("User successfully authenticated");
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
