package com.db.employeemicroservice.controller;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.db.employeemicroservice.dto.Employee;
import com.db.employeemicroservice.service.EmployeeService;

@RestController // dedicated to rest api
//@responsebody + @controller is used to share the response with client/consumer
//@controller will be used for mvc
@RequestMapping("/api/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/{id}")
	
	public ResponseEntity<?> getEmployeeById(@PathVariable("id") String empId){
		
		Optional<Employee> optional = employeeService.getEmployeeById(empId);
		
		if(optional.isPresent()) {
			return ResponseEntity.of(optional);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping
	public ResponseEntity<?> getAllEmployees(){
		List<Employee> employees = employeeService.getEmployees();
		
		return ResponseEntity.status(HttpStatus.OK).body(employees);
		//spring boot transforms ur objects into json objects.
		//if it is collection it will send it in terms of json array
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> createEmployee(@RequestBody Employee employee){
		employeeService.addEmployee(employee);
		return ResponseEntity.status(HttpStatus.CREATED).body(employee);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteEmployeeById(@PathVariable("id") String empId){
		
		employeeService.deleteEmployeeById(empId);
		return ResponseEntity.ok().build();
		
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateEmployee(@RequestBody Employee employee,
			@PathVariable("id") String id){
		
		employeeService.addEmployee(employee);
		//save ==> insert and update
		// 
		return ResponseEntity.status(HttpStatus.OK).body(employee);
		
	}
}
