package com.aws.poc.dynamodb.repo;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.aws.poc.dynamodb.model.StudentModel;

@EnableScan
public interface StudentDynamoDBRepo extends CrudRepository<StudentModel, String> {

}
