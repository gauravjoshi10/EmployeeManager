package com.javaspringapplication.employeeManager.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaspringapplication.employeeManager.model.Employee;
import com.javaspringapplication.employeeManager.service.EmployeeServices;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	private final EmployeeServices employeeService;

	public EmployeeController(EmployeeServices employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployee()
	{
		List<Employee> employee= employeeService.findAllEmployee();
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}
	
	@GetMapping("/all/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id)
	{
		Employee employee= employeeService.findById(id);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee)
	{
		Employee newEmployee= employeeService.addEmployee(employee);
		return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee)
	{
		Employee updateEmployee= employeeService.updateEmployee(employee);
		return new ResponseEntity<>(updateEmployee, HttpStatus.OK);

	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteEmployeeById(@PathVariable("id") Long id)
	{
		employeeService.deleteEmployee(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
