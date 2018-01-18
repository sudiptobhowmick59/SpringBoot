package com.aws.poc.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.model.S3Object;
import com.aws.poc.dto.Student;
import com.aws.poc.dto.StudentError;
import com.aws.poc.service.StudentService;

@RestController
public class StudentController {

	//private static String UPLOADED_FOLDER = "D://Sudipto_sxb9638//DD_Logs//";
	
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
	
	@GetMapping("student/download/{fileName:.+}")
	public ResponseEntity<Resource> download(@PathVariable("fileName") String fileName) throws IOException {
		
		S3Object s3object = studentSvc.getFilesFromS3(fileName);
		
		//File file2Download = new File(UPLOADED_FOLDER + fileName);
		//InputStreamResource resource = new InputStreamResource(new FileInputStream(file2Download));
		InputStreamResource resource = new InputStreamResource(s3object.getObjectContent());
		String mimeType= s3object.getObjectMetadata().getContentType();
				//URLConnection.guessContentTypeFromName(fileName);
		HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Content-Disposition", String.format("inline; filename=\"" + fileName +"\""));
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");
        
	    return ResponseEntity.ok()
	            .headers(headers)
	            .contentLength(s3object.getObjectMetadata().getContentLength())
	            .contentType(MediaType.parseMediaType(mimeType))
	            .body(resource);
		
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String rootPath(){
		return "Hello";
	}
}
