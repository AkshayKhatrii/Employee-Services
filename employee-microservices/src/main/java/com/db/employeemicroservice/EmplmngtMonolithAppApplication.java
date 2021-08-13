package com.db.employeemicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;

import com.db.employeemicroservice.dto.Employee;
import com.db.employeemicroservice.service.EmployeeService;
import com.db.employeemicroservice.service.EmployeeServiceImpl;

@SpringBootApplication
@EnableEurekaClient
public class EmplmngtMonolithAppApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = 
				SpringApplication.run(EmplmngtMonolithAppApplication.class, args);
		
		EmployeeService employeeService = applicationContext.getBean(EmployeeServiceImpl.class);
		employeeService.addEmployee(new Employee("ab001","Akshay","Khatri",1234.7f,"Mumbai"));
		employeeService.addEmployee(new Employee("ab002","Akshay","Khatri",1234.7f,"Mumbai"));
		System.out.println(employeeService.getEmployeeById("ab001"));
	}

}
