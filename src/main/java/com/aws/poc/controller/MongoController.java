package com.aws.poc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
