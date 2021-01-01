package com.hospital.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.exception.ResourceNotFountException;
import com.hospital.model.Employee;
import com.hospital.model.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
	
	@Autowired     // we inject employeeRepository because employeerepository is connected to the database
	private EmployeeRepository employeeRepository;
	
	@GetMapping("/employees")
     public List<Employee> getAllEmployee(){
    	 return employeeRepository.findAll();
     }
	
	// post employee method sending data to database
	@PostMapping("/employees")
	public Employee createEmployees(@RequestBody Employee employee) {  // infront of @RequestBody we type Entity class name which is Employee
	return employeeRepository.save(employee);
	}
	
	// update employee
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,@RequestBody Employee employeeDetails){
		Employee employee = employeeRepository.findById(id).orElseThrow(()->new ResourceNotFountException("Employee not available:"+id));
		employee.setFirstName(employeeDetails.getFirstName());
		employee.setLastName(employeeDetails.getEmail());
		employee.setEmail(employeeDetails.getEmail()); 
		
		Employee updateEmployee= employeeRepository.save(employee);
		return ResponseEntity.ok(employee);
	}
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Map<String,Boolean>> deleteEmployee(@PathVariable Long id){
		Employee employee=employeeRepository.findById(id).orElseThrow(()->new ResourceNotFountException("The value does not exist:"+id));
		
		employeeRepository.delete(employee);
		Map<String,Boolean> response= new HashMap<String,Boolean>();
		response.put("The data deleted successfully",Boolean.TRUE);
		return ResponseEntity.ok(response);
	} 
	
}
