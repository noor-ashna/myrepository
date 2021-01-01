package com.spring.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration   // Creating bean of third party class 
public class DataSourceConfig {
                                  // Step 2 Second create this (2)
	// on third party class we cannot put annotation on class
	// @Bean - hey what ever object this method returns
	// push into spring container
	/*<bean id = "dataSource"
			class = "org.springframework.jdbc.datasource.DriverManagerDataSource">
			   <property name = "driverClassName" value = "com.mysql.jdbc.Driver"/>
			   <property name = "url" value = "jdbc:mysql://localhost:3306/TEST"/>
			   <property name = "username" value = "root"/>
			   <property name = "password" value = "admin"/>
			</bean>*/
	@Bean 
	public DataSource methodNameCanBeAnything() {                   // step 2
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setUrl("jdbc:mysql://localhost:3306/mydatabase");
		ds.setUsername("root");
		ds.setPassword("mysql");
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		return ds;
	}
	
	@Bean
	public JdbcTemplate getJdbcTemplate(){
		JdbcTemplate jdbcTemplate=new JdbcTemplate(methodNameCanBeAnything());
		return jdbcTemplate;
	}

}
