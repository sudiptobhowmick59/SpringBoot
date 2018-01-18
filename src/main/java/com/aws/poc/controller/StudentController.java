package com.aws.poc.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.aws.poc.dto.Student;
import com.aws.poc.dto.StudentError;
import com.aws.poc.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService studentSvc;
	
	@RequestMapping(value="/students", method=RequestMethod.GET)
	public List<Student> getStudents(){
		return studentSvc.getStudents();
	}
	
	@RequestMapping(value="/student/add", method=RequestMethod.PUT)
	public Object addStudents(@RequestBody Student newStudent){
		if(newStudent.validate()){
			return  studentSvc.addStudent(newStudent);
		}else{
			return new StudentError("503", "Please send a valid Student record");
		}
	}
	
	@RequestMapping(value="/student/update", method=RequestMethod.POST)
	public Object modifyStudents(@RequestBody Student newStudent){
		if(newStudent.validate()){
			return  studentSvc.updateStudents(newStudent);
		}else{
			return new StudentError("503", "Please send a valid Student record");
		}
	}
	
	@RequestMapping(value="/student/delete/{rollNumber}", method=RequestMethod.DELETE)
	public Object deleteStudents(@PathVariable("rollNumber") Integer rollNumber){
		if((null != rollNumber) && rollNumber > 0){
			return  studentSvc.deleteStudent(rollNumber);
		}else{
			return new StudentError("503", "Please send a valid roll number");
		}
	}
	
	@PostMapping("/student/upload")
	public Object uploadFile(@RequestParam("file") MultipartFile uploadfile) throws IOException{
		
		if(null != uploadfile && uploadfile.isEmpty()){
			return new StudentError("503", "Please upload a valid file");
		}
		
		studentSvc.saveUploadedFiles(uploadfile);
		
		return "File Sucessfully Uploaded";
		
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String rootPath(){
		return "Hello";
	}
}
