package com.aws.poc.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.model.S3Object;
import com.aws.poc.dto.Student;
import com.aws.poc.mongodb.model.MongoPOCTable;
import com.aws.poc.sqlserver.model.POCTable;


public interface StudentService {

	public List<Student> getStudents();
	
	public List<Student> addStudent(Student newStudent);
	
	public List<Student> updateStudents(Student modifyStudent);
	
	public List<Student> deleteStudent(Integer rollNumber);

	public void saveUploadedFiles(MultipartFile file) throws IOException;

	public S3Object getFilesFromS3(String fileName) throws IOException;

	public List<POCTable> findAllStoreDC();

	public List<MongoPOCTable> findAllMongoStoreDC();

	public List<com.aws.poc.mongodb.model.Student> findAllMongoStudents();

	public List<MongoPOCTable> saveMongoStoreDC();
}
