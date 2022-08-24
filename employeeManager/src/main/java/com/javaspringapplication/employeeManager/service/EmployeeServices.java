package com.javaspringapplication.employeeManager.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaspringapplication.employeeManager.exception.UserNotFoundException;
import com.javaspringapplication.employeeManager.model.Employee;
import com.javaspringapplication.employeeManager.repository.EmployeeRepository;

@Service
public class EmployeeServices {
	private final EmployeeRepository employeeRepo;

	@Autowired
	public EmployeeServices(EmployeeRepository employeeRepo) {
		this.employeeRepo = employeeRepo;
	}

	public Employee addEmployee(Employee employee) {
		employee.setEmployeeCode(UUID.randomUUID().toString());
		return employeeRepo.save(employee);
	}

	public List<Employee> findAllEmployee() {
		return employeeRepo.findAll();
	}

	public Employee updateEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}

	public Employee findById(Long id) {
		return employeeRepo.findElementById(id).orElseThrow(() -> new UserNotFoundException("User not found"));

	}

	public void deleteEmployee(Long id) {
		employeeRepo.deleteById(id);
	}
}
