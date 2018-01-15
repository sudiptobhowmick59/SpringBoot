package com.aws.poc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aws.poc.dto.Student;
import com.aws.poc.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService studentSvc;
	
	@RequestMapping(value="/students", method=RequestMethod.GET)
	public List<Student> getStudents(){
		return studentSvc.getStudents();
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String rootPath(){
		return "Hello";
	}
}
