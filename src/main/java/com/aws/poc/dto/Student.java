package com.aws.poc.dto;

import java.io.Serializable;

public class Student implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String name;
	
	private Integer rollNumber;
	
	private String department;
	
	private String schoolName;

	
	public Student(String name, Integer rollNumber, String department, String schoolName) {
		super();
		this.name = name;
		this.rollNumber = rollNumber;
		this.department = department;
		this.schoolName = schoolName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(Integer rollNumber) {
		this.rollNumber = rollNumber;
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
