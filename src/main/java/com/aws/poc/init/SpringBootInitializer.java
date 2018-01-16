package com.aws.poc.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages="com.aws.poc")
public class SpringBootInitializer {

	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootInitializer.class, args);
	}

}
