
package com.huge.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration // creating bean using bean annotation public class dataConfig
public class DataConfig {
	@Bean("pkdataSource")
	public DataSource createData() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/mydatabase");
		dataSource.setUsername("root");
		dataSource.setPassword("mysql");
		return dataSource;

	}
}
