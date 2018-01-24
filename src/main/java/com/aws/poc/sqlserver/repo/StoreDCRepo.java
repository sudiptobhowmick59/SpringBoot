package com.aws.poc.sqlserver.repo;

import org.springframework.data.repository.CrudRepository;

import com.aws.poc.sqlserver.model.POCTable;

public interface StoreDCRepo extends CrudRepository<POCTable, Integer> {

}
