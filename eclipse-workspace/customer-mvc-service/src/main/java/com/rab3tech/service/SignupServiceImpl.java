package com.rab3tech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rab3tech.controller.SignUp;
import com.rab3tech.dao.SignupDao;

@Service
public class SignupServiceImpl implements SignupService {

	@Autowired
	private SignupDao signupDao;

	@Override
	public void delete(String sid) {
		signupDao.delete(sid);
	}

	@Override
	public List<SignUp> findAll() {
		List<SignUp>  signUps=signupDao.findAll();
		return signUps;
	}

	@Override
	public void save(SignUp signUp) {
		signupDao.save(signUp);
	}

	@Override
	public List<SignUp> authUser(String username, String password) {
		List<SignUp>  signUps=signupDao.authUser(username,password);
		return signUps;
	}
	
	
	
}
