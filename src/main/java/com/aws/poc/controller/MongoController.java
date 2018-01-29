package com.aws.poc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aws.poc.mongodb.model.MongoPOCTable;
import com.aws.poc.mongodb.model.Student;
import com.aws.poc.service.StudentService;
import com.aws.poc.sqlserver.model.POCTable;

@RestController
public class MongoController {

	@Autowired
	StudentService studentSvc;
	
	@GetMapping(value="/storedcs")
	public List<POCTable> findAllStoreDC(){
		return studentSvc.findAllStoreDC();
	}
	
	@GetMapping(value="/mongo/storedcs")
	public List<MongoPOCTable> findAllMongoStoreDC(){
		return studentSvc.findAllMongoStoreDC();
	}
	
	@GetMapping(value="/mongo/students")
	public List<Student> findAllMongoStudents(){
		return studentSvc.findAllMongoStudents();
	}
	
	@GetMapping(value="/mongo/add/storedcs")
	public List<MongoPOCTable> addMongoStoreDC(){
		return studentSvc.saveMongoStoreDC();
	}
}
