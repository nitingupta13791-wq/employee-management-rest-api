package com.nitin.employee_management_rest_api.controller;

import java.net.http.HttpResponse;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nitin.employee_management_rest_api.entity.Employee;
import com.nitin.employee_management_rest_api.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
public class EmployeeController {
	
	private final EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	@PostMapping("/employees")
	public Employee addEmployee(@Valid @RequestBody Employee employee) {
		return employeeService.addEmployee(employee);
	}
	@GetMapping("/employees")
	public List<Employee> getAllEmployee() {
		return employeeService.getAllEmployee();
	}
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) {
		Employee employee= employeeService.getEmployeeById(id);
		
		if(employee==null) {
			return ResponseEntity.notFound().build();
		}
		else {
			return ResponseEntity.ok(employee);
	}
	}
	
	@PutMapping("/employees/{id}")
	public Employee UpdateEmployee(@Valid @PathVariable int id, @RequestBody Employee employee) {
		return employeeService.UpdateEmployee(id, employee);
	}
	@DeleteMapping("/employees/{id}")
	public void deleteEmployee(@PathVariable int id) {
	    employeeService.deleteEmployee(id);
	}
	
	
	@GetMapping("/employees/department/{department}")
	public List<Employee> getEmployeesByDepartment(@PathVariable String department) {
	    return employeeService.getEmployeesByDepartment(department);
	}
	
	@GetMapping("/employees/salary/{salary}")
	public List<Employee> findBySalaryGratherThan(@PathVariable Double salary){
		return employeeService.findBySalaryGreaterThan(salary);
	}
	

}
