package com.aws.poc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Student")
public class Student implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "RollNumber")
	private Integer rollNumber;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "Department")
	private String department;
	
	@Column(name = "SchoolName")
	private String schoolName;

	public Integer getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(Integer rollNumber) {
		this.rollNumber = rollNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

}
