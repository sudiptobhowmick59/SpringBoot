package com.aws.poc.sqlserver.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = "com.aws.poc.sqlserver.repo")
@EntityScan("com.aws.poc.sqlserver.model") 
@EnableTransactionManagement
public class SQLServerConfig {

}
