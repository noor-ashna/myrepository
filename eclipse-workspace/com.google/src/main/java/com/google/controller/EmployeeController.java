package com.google.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.google.exception.ResourceNotFountException;
import com.google.model.Employee;
import com.google.model.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

	// we ineject EmployeesRepository
	@Autowired
	EmployeeRepository employeesRepository; 

	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {   

		return employeesRepository.findAll();
	}

	// post employee method   

	@PostMapping("/employees")
	public Employee createEmployees(@RequestBody Employee employee) {

		return employeesRepository.save(employee);
	}

	// update employee
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updatEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {
		Employee employee = employeesRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFountException("employee not exits with: " + id));
		employee.setFirstName(employeeDetails.getFirstName());
		employee.setLastName(employeeDetails.getLastName());
		employee.setEmail(employeeDetails.getEmail());

		Employee upatEmployee = employeesRepository.save(employee);
		return ResponseEntity.ok(employee);
	}

	// delete employees

	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id) {

		Employee employee = employeesRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFountException("employee not exist: " + id));
		employeesRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<String, Boolean>();
		response.put("Deleted", Boolean.TRUE);

		return ResponseEntity.ok(response);
	}

}
