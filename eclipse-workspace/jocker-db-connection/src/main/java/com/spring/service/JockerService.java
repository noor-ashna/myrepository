package com.spring.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.spring.model.Jocker;

//Creating a bean
@Service                                // Step-3 creating this  
public class JockerService {
	//same way as ref in XML file
	
	@Autowired  // we push @bean into it or inject it from DataSourceConfig class
	private JdbcTemplate jdbcTemplate;
	
	public String save(Jocker jocker){
		String sql="insert into jockers_tbl(name,age,price,email,doe) values(?,?,?,?,?)";
		Object data[]={jocker.getName(),jocker.getAge(),jocker.getPrice(),jocker.getEmail(),new Timestamp(new Date().getTime())};
		jdbcTemplate.update(sql,data);
		return "saved!";
	}
	
	public String update(Jocker jocker){
		String sql="update jockers_tbl set name=?,age=?,price=?,email=? where jid=?";
		Object data[]={jocker.getName(),jocker.getAge(),jocker.getPrice(),jocker.getEmail(),jocker.getJid()};
		jdbcTemplate.update(sql,data);
		return "updated!";
	}
	
	public List<Jocker> findAll(){
		String sql="select jid,name,age,price,email,doe from jockers_tbl";
		List<Jocker> jockers=jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Jocker.class));
		return jockers;
	}
	
	public List<String> findAllNames(){
		String sql="select name from jockers_tbl";
		//Special methods
		List<String> jockerNames=jdbcTemplate.queryForList(sql,String.class);
		return jockerNames;
	}
	
	public Jocker findById(int jid){
		String sql="select jid,name,age,price,email,doe from jockers_tbl where jid = "+jid;
		Jocker jocker=jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(Jocker.class));
		return jocker;
	}
	
	public void deleteById(int jid){
		String sql="delete from jockers_tbl where jid = "+jid;
		jdbcTemplate.update(sql);
	}
	
	public long count(){
		String sql="select count(*) jockers_tbl";
		long count=jdbcTemplate.queryForObject(sql,Integer.class);
		return count;
	}
	
	
}
