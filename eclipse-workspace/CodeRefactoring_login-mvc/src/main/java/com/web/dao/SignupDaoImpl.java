package com.web.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.controller.vo.Signup;
import com.web.dao.entity.SignupEntity;

@Repository // creating bean of Dao layer
public class SignupDaoImpl implements SignupDao {

	@Autowired
	private JdbcTemplate jdbcTemplate; // we moved it from LoginController

	@Override
	public void update(Signup signup) {

		String sql = "update user_profiles_tbl set username=?,password=?,role =?,name=?,email=?,gender=?,photo=? where lid=?";
		Object[] data = { signup.getUsername(), signup.getPassword(), signup.getRole(), signup.getName(),
				signup.getEmail(), signup.getGender(), signup.getPhoto(), signup.getLid() };
		jdbcTemplate.update(sql, data);
	}

	@Override
	public Map<String, Object> authUser(String username, String password) {
		String sql = "select username,password,role,name,email,gender,photo from user_profiles_tbl where username=? and password=?";
		Map<String, Object> mapsdata = new HashMap();
		try {
			mapsdata = jdbcTemplate.queryForMap(sql, username, password);
		} catch (DataAccessException e) {
		}
		return mapsdata;
	}

	@Override
	public List<SignupEntity> findAll() {
		String sql = "select lid,username,password,role,name,email,gender,photo from user_profiles_tbl";
		List<SignupEntity> dsignups = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(SignupEntity.class));
		return dsignups;
	}

	@Override
	public SignupEntity findByUsername(String username) {
		String sql = "select lid,username,password,role,name,email,gender,photo from user_profiles_tbl where username = ?";
		SignupEntity signup = jdbcTemplate.queryForObject(sql, new Object[] { username },
				new BeanPropertyRowMapper<>(SignupEntity.class));

		return signup;
	}

	@Override
	public void save(Signup signup) {

		String sql = "insert into user_profiles_tbl (username,password,role,name,email,gender,photo) values(?,?,?,?,?,?,?)";
		Object[] data = { signup.getUsername(), signup.getPassword(), signup.getRole(), signup.getName(),
				signup.getEmail(), signup.getGender(), signup.getPhoto() };
		jdbcTemplate.update(sql, data);

	}

	@Override
	public void delete(String username) {
		// Fetch All the data before going to this page
		String sql = "delete from user_profiles_tbl where username = ? ";
		jdbcTemplate.update(sql, username);
	}

	@Override
	public void update(SignupEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(SignupEntity entity) {
		// TODO Auto-generated method stub
		
	}

}
