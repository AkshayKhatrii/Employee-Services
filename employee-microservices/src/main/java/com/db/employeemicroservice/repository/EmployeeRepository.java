package com.db.employeemicroservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.db.employeemicroservice.dto.Employee;

@Repository // repository work ==> jpa data
public interface EmployeeRepository extends JpaRepository<Employee, String>{

//	public String addEmployee(Employee employee); // adding a new Employee
//	public String updateEmployee(String empId, Employee employee); 
//	// to update emp info based on empid
//	
//	public Employee getEmployeeById(String empId);
//	// should provide the employee details based on empId
//	public List<Employee> getEmployees();
//	// should return all Employee Details. in terms of List.
//	
//	public String deleteEmployeeById(String id);
//	public String deleteAllEmployees();
	
}
