package com.aws.poc.init;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.aws.poc.dto.Student;


@SpringBootApplication
@ComponentScan(basePackages="com.aws.poc")
public class SpringBootInitializer {

	public static List<Student> students = new ArrayList<Student>();
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootInitializer.class, args);
		
		Student s1 = new Student("Sudipto", 12345, "Science", "ST THOMAS HIGH SCOOL");
		Student s2 = new Student("Samba", 32347, "Science", "DON BOSCO");
		Student s3 = new Student("Anindita", 89875, "Commerce", "MODERN HIGH SCHOOL");
		
		students.add(s1);
		students.add(s2);
		students.add(s3);
		
	}

}
