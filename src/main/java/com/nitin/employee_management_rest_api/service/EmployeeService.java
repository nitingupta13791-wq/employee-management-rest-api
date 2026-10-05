package com.nitin.employee_management_rest_api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nitin.employee_management_rest_api.entity.Employee;
import com.nitin.employee_management_rest_api.repository.EmployeeRepository;


@Service
public class EmployeeService {
	
 private final	EmployeeRepository employeeRepository;

 public EmployeeService(EmployeeRepository employeeRepository) {
	
	this.employeeRepository = employeeRepository;
 }
	
 
    public Employee addEmployee(Employee employee) {
    	return employeeRepository.save(employee);
    }
    
    public List<Employee> getAllEmployee(){
    	return employeeRepository.findAll();
    }
    
    public Employee getEmployeeById(int id) {
    	return employeeRepository.findById(id).orElse(null);
    }
    
    public Employee UpdateEmployee(int id, Employee employee) {
    	Employee exsistingEmployee =employeeRepository.findById(id).orElse(null);
    	
    	if(exsistingEmployee==null) {
    		return null;
    	}
    	else {
    		exsistingEmployee.setName(employee.getName());
    		exsistingEmployee.setEmail(employee.getEmail());
    		exsistingEmployee.setDepartment(employee.getDepartment());
    		exsistingEmployee.setSalary(employee.getSalary());
    		
    		return employeeRepository.save(exsistingEmployee);
    	}
    }
    
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }

    public List<Employee> getEmployeesByDepartment(String department) {
        return employeeRepository.findByDepartment(department);
    }
    
    public List<Employee> findBySalaryGreaterThan(double salary){
    	return employeeRepository.findBySalaryGreaterThan(salary);
    	
    }
}
