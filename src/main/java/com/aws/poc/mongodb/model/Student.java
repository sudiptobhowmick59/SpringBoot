package com.aws.poc.mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.util.StringUtils;

@Document(collection = "Student")
public class Student{

	@Id
	private String rollNumber;
	
	private String name;
	
	private String department;
	
	private String schoolName;

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(String rollNumber) {
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
	
	public Boolean validate(){
		if (StringUtils.isEmpty(rollNumber) || StringUtils.isEmpty(name) 
				|| StringUtils.isEmpty(department) || StringUtils.isEmpty(schoolName) ){
			return Boolean.FALSE;
		}
		
		return Boolean.TRUE;
	}
	
}
