package com.aws.poc.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.aws.poc.dto.Student;
import com.aws.poc.service.StudentService;
import com.aws.poc.sqlserver.model.POCTable;
import com.aws.poc.sqlserver.repo.StoreDCRepo;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StoreDCRepo storeDcRepo;
	
	AmazonS3 s3Client = null;
	
	public List<Student> students = new ArrayList<Student>();
	
	//private static String UPLOADED_FOLDER = "D://Sudipto_sxb9638//DD_Logs//";
	
	public Comparator<Student> sortByRollNumber = (student1, student2) -> student1.getRollNumber().compareTo(student2.getRollNumber());
	
	@PostConstruct
	public void buildStudentCache(){
		Student s1 = new Student("Sudipto", 12345, "Science", "ST THOMAS HIGH SCOOL");
		Student s2 = new Student("Samba", 32347, "Science", "DON BOSCO");
		Student s3 = new Student("Sourav", 89875, "Commerce", "SOUTH POINT");
		
		students.add(s1);
		students.add(s2);
		students.add(s3);
		Collections.sort(students, sortByRollNumber);
		
		String awsId = "";
		String awsKey = "";
		//BasicAWSCredentials awsCreds = new BasicAWSCredentials(awsId, awsKey);
		
		//s3Client = AmazonS3ClientBuilder.defaultClient();
		/*AmazonS3ClientBuilder
				.standard()
				.withRegion("us-east-1")
				.withCredentials(new ProfileCredentialsProvider())
				.build();*/
	}
	
	@Override
	public List<Student> getStudents() {
		return students;
	}

	@Override
	public List<Student> addStudent(Student newStudent) {
		students.add(newStudent);
		Collections.sort(students, sortByRollNumber);
		return students;
	}

	@Override
	public List<Student> updateStudents(Student modifyStudent) {
		Student record = null;
		for (Student data: students) {
			if(data != null && data.getRollNumber().equals(modifyStudent.getRollNumber())){
				record = data;
			}
		}
		
		if(record != null){
			record.setDepartment(modifyStudent.getDepartment());
			record.setName(modifyStudent.getName());
			record.setSchoolName(modifyStudent.getSchoolName());
		}
		
		Collections.sort(students, sortByRollNumber);
		return students;
	}

	@Override
	public List<Student> deleteStudent(Integer rollNumber) {
		List<Student> record = new ArrayList<Student>();
		Stream<Student> studentStream = students .stream();
		//Predicate<Student> selectData = (Student record1) -> record1.getRollNumber().equals(1);
		studentStream.filter(student -> student.getRollNumber().equals(rollNumber))
					 .forEach(record::add);;
		
		if(record != null){
			students.removeAll(record);
		}
		
		Collections.sort(students, sortByRollNumber);
		return students;
	}
	
	@Override
    public void saveUploadedFiles (MultipartFile file) throws IOException {
		s3Client.putObject(new PutObjectRequest("sudipto-aws-poc-springboot", file.getOriginalFilename(), convert(file)));
    }
	
	@Override
    public S3Object getFilesFromS3 (String fileName) throws IOException {
		return s3Client.getObject(new GetObjectRequest("sudipto-aws-poc-springboot", fileName));
	}
	
	public File convert(MultipartFile file) throws IOException {
	    File convFile = new File(file.getOriginalFilename());
	    convFile.createNewFile();
	    FileOutputStream fos = new FileOutputStream(convFile);
	    fos.write(file.getBytes());
	    fos.close();
	    return convFile;
	}

	@Override
	public List<POCTable> findAllStoreDC() {
		return (List<POCTable>) storeDcRepo.findAll();
	}

}
