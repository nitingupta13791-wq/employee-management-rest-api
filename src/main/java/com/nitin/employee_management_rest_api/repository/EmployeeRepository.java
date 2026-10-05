package com.nitin.employee_management_rest_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nitin.employee_management_rest_api.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	List<Employee> findByDepartment(String department);
	
	List<Employee> findBySalaryGreaterThan(double salary);

}
