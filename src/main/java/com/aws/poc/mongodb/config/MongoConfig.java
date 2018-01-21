package com.aws.poc.mongodb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClient;

@Configuration
@EnableMongoRepositories(basePackages = "com.aws.poc.mongodb.repo")
public class MongoConfig extends AbstractMongoConfiguration {

	@Override
	public MongoClient mongo() {
		return new MongoClient("localhost", 27017);
	}

	@Override
	protected String getDatabaseName() {
		return "MongoPOC";
	}
	
	@Override
    protected String getMappingBasePackage() {
        return "com.aws.poc.mongodb";
    }
}
