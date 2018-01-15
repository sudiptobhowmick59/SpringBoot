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

}
