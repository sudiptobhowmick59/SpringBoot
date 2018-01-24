package com.aws.poc.sqlserver.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "POCTable")
public class POCTable extends BaseEntity implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "Id")
    private int id;
	
    @Column(name = "Name")
    private String name;

    @Column(name = "Email")
    private String email;

    @Column(name = "Phone")
    private String phone;
    
    @Column(name = "Gender")
    private String gender;

    
    
}
