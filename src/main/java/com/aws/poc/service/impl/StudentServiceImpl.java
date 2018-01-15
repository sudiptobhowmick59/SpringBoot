package com.aws.poc.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aws.poc.dto.Student;
import com.aws.poc.init.SpringBootInitializer;
import com.aws.poc.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Override
	public List<Student> getStudents() {
		return SpringBootInitializer.students;
	}

	@Override
	public List<Student> addStudent(Student newStudent) {
		SpringBootInitializer.students.add(newStudent);
		return SpringBootInitializer.students;
	}

	@Override
	public List<Student> updateStudents(Student modifyStudent) {
		Student record = null;
		for (Student data: SpringBootInitializer.students) {
			if(data != null && data.getRollNumber().equals(modifyStudent.getRollNumber())){
				record = data;
			}
		}
		
		if(record != null){
			record.setDepartment(modifyStudent.getDepartment());
			record.setName(modifyStudent.getName());
			record.setSchoolName(modifyStudent.getSchoolName());
		}
		return SpringBootInitializer.students;
	}

	@Override
	public List<Student> deleteStudent(Integer rollNumber) {
		// TODO Auto-generated method stub
		Student record = null;
		for (Student data: SpringBootInitializer.students) {
			if(data != null && data.getRollNumber().equals(rollNumber)){
				record = data;
			}
		}
		
		if(record != null){
			SpringBootInitializer.students.remove(record);
		}
		return SpringBootInitializer.students;
	}

}
