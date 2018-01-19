package com.aws.poc.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.aws.poc.model.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {
	
	List<Student> findByName(String name);

}
