package com.aws.poc.service;

import java.util.List;

import com.aws.poc.dto.Student;


public interface StudentService {

	public List<Student> getStudents();
	
	public List<Student> addStudent(Student newStudent);
	
	public List<Student> updateStudents(Student modifyStudent);
	
	public List<Student> deleteStudent(Integer rollNumber);
}
