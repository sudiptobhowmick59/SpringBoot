package com.aws.poc.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.aws.poc.dto.Student;
import com.aws.poc.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	
	public List<Student> students = new ArrayList<Student>();
	
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

}
