package com.web.controller;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DataSourceConfig {                                                 // Creating dataSource to connect to the database

	@Bean 
	public DataSource methodNameCanBeAnything() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setUrl("jdbc:mysql://localhost:3306/alldata");
		ds.setUsername("root");
		ds.setPassword("mysql");
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		return ds;
	}
	
	@Bean 
	public JdbcTemplate getJdbcTemplate(){                          // creating this JdbcTemplate and then Autowired it in Login Controller 
		JdbcTemplate jdbcTemplate=new JdbcTemplate(methodNameCanBeAnything());
		return jdbcTemplate; 
	}

}
