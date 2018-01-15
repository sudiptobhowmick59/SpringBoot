package com.aws.poc.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aws.poc.dto.Student;
import com.aws.poc.init.SpringBootInitializer;

@RestController
public class StudentController {

	@RequestMapping(value="/students", method=RequestMethod.GET)
	public List<Student> getStudents(){
		return SpringBootInitializer.students;
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String rootPath(){
		return "Hello";
	}
}
