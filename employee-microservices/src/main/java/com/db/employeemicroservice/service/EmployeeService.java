package com.db.employeemicroservice.service;

import java.util.List;
import java.util.Optional;

import com.db.employeemicroservice.dto.Employee;

public interface EmployeeService {

	public Employee addEmployee(Employee employee); // adding a new Employee
	public String updateEmployee(String empId, Employee employee); 
	// to update emp info based on empid
	
	public Optional<Employee> getEmployeeById(String empId);
	// should provide the employee details based on empId
	public List<Employee> getEmployees();
	// should return all Employee Details. in terms of List.
	public String deleteEmployeeById(String id);
	public String deleteAllEmployees();
	
}
