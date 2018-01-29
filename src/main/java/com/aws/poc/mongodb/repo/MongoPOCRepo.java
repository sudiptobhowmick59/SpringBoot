package com.aws.poc.mongodb.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.aws.poc.mongodb.model.MongoPOCTable;

public interface MongoPOCRepo extends MongoRepository<MongoPOCTable, Integer>{

	List<MongoPOCTable> findAll();
}
