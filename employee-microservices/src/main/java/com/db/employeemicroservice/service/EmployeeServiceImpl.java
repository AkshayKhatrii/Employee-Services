package com.db.employeemicroservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db.employeemicroservice.dto.Employee;
import com.db.employeemicroservice.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired //will perform DI ==> required object it will provide you implicitly

	private EmployeeRepository employeeRepository;
	@Override
	public Employee addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}

	@Override
	public String updateEmployee(String empId, Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Employee> getEmployeeById(String empId) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(empId);
	
	}

	@Override
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return this.employeeRepository.findAll();
	}
	
	public String deleteEmployeeById(String id) {
		try {
			Optional<Employee> employee=this.getEmployeeById(id);
			this.employeeRepository.deleteById(id);
			if (employee.isPresent()) {return "success";}
			else {return "notfound";}
		}
		catch(Exception e) {
			e.printStackTrace();
			return "problem";
		}
	}
	public String deleteAllEmployees() {
		try {
			this.employeeRepository.deleteAll();
			return "success";
		}
		catch(Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}

}
