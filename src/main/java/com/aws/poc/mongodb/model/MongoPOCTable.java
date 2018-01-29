package com.aws.poc.mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "StoreDC")
public class MongoPOCTable{

	@Id
    private int id;
	
    private String name;

    private String gender;

    private String mobile;
    
    private String salary;

    
    
}
