/*package com.web.dao;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class AuthDaoImpl implements  AuthDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Override
	public ProfileEntity findByEmail(String email) {
		String sql = "select * from profile_tbl where email = ?";
		List<ProfileEntity> list = jdbcTemplate.query(sql,new Object[]{email},
				new BeanPropertyRowMapper<ProfileEntity>(ProfileEntity.class));
			return  list.get(0);
	}
	
	
	@Override
	public List<ProfileEntity> findAll() {
		String sql = "select * from profile_tbl";
		List<ProfileEntity> list = jdbcTemplate.query(sql,
				new BeanPropertyRowMapper<ProfileEntity>(ProfileEntity.class));
			return  list;
	}
	
	@Override
	public ProfileEntity findByUsernamePass(String username, String password) {
		String sql = "select * from profile_tbl where username =?  and password=?";
		List<ProfileEntity> list = jdbcTemplate.query(sql, new Object[] { username, password },
				new BeanPropertyRowMapper<ProfileEntity>(ProfileEntity.class));
		if (list.size() == 0) {
			return null;
		} else {
			return list.get(0);
		}
	}
	
	@Override
	public void deleteByUsername(String username) {
		String sql = "delete from profile_tbl where username =?";
	    jdbcTemplate.update(sql, new Object[] { username });
	}

	@Override
	public void saveProfile(ProfileEntity entity) {
		String sql = "insert into profile_tbl(username,password,name,email,mobile,gender,ssn,doe) values(?,?,?,?,?,?,?,?)";
	    Object[] data={entity.getUsername(),entity.getPassword(),entity.getName(),entity.getEmail(),entity.getMobile(),entity.getGender(),entity.getSsn(),new Timestamp(new Date().getTime())};
	    jdbcTemplate.update(sql,data);
	}


	@Override
	public void updateProfile(ProfileEntity entity) {
		String sql = "update profile_tbl set name=?,email=?,mobile=? where pid=?";
	    Object[] data={entity.getName(),entity.getEmail(),entity.getMobile(),entity.getPid()};
	    jdbcTemplate.update(sql,data);
	}
	
}
*/