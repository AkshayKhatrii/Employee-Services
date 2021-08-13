package com.db.employeemicroservice.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

//ORM mapping: object relational mapping
// class ==> table
// fields ==> columns
@Entity
@Table(name = "emplTbl")
public class Employee {

	@Id  //as a PK   String ==>> varchar
	@Column(name = "employeeId")
	private String empId;
	private String empFirstName;
	private String empLastName;
	private float empSalary;
	private String address;
}
