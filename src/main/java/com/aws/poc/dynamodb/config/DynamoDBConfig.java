package com.aws.poc.dynamodb.config;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;

@Configuration
@EnableDynamoDBRepositories(basePackages = "com.aws.poc.dynamodb.repo")
public class DynamoDBConfig {
	
	@Bean
	public AmazonDynamoDB amazonDynamoDB(){
		
		String awsId = "55";
		String awsKey = "33";
		BasicAWSCredentials awsCreds = new BasicAWSCredentials(awsId, awsKey);
		
		AmazonDynamoDB dynamoDB = new AmazonDynamoDBClient(awsCreds);
		
		return dynamoDB;
	}

}
