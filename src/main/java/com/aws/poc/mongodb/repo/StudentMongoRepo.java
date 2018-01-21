package com.aws.poc.mongodb.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.aws.poc.mongodb.model.Student;

public interface StudentMongoRepo extends MongoRepository<Student, String>{

	List<com.aws.poc.mongodb.model.Student> findAll();

}
