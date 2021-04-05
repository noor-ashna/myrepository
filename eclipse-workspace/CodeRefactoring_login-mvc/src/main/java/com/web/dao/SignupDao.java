package com.web.dao;

import java.util.List;
import java.util.Map;

import com.web.controller.vo.Signup;
import com.web.dao.entity.SignupEntity;

public interface SignupDao {

	void update(SignupEntity entity);

	void save(SignupEntity entity);

	void delete(String username);

	SignupEntity findByUsername(String username);

	List<SignupEntity> findAll();

	Map<String, Object> authUser(String username, String password);

}
