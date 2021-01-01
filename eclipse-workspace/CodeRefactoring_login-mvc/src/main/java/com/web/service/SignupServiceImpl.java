package com.web.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.controller.vo.Signup;
import com.web.dao.SignupDao;
import com.web.dao.entity.SignupEntity;

@Service // Making bean of service
public class SignupServiceImpl implements SignupService {

	@Autowired           // service should @Autowired dao layer
	private SignupDao signupDao;

	@Override
	public void update(Signup signup) {
		SignupEntity entity = new SignupEntity();
		BeanUtils.copyProperties(signup, entity);
		signupDao.update(entity);

	}

	@Override
	public void save(Signup signup) {
		SignupEntity entity = new SignupEntity();
		BeanUtils.copyProperties(signup, entity);
		signupDao.save(entity);

	}

	@Override
	public void delete(String username) {
		signupDao.delete(username);
	}

	@Override
	public Signup findByUsername(String username) {
		SignupEntity entity = signupDao.findByUsername(username);
		Signup signup= new Signup();
		BeanUtils.copyProperties(entity, signup);
		return signup;
	}

	@Override
	public List<Signup> findAll() {
		List<SignupEntity> signups = signupDao.findAll();
		List<Signup>signups2= new ArrayList<Signup>();
		// Converting List<SignupEntity> into List<Signup>
		for(SignupEntity entity:signups) {
			Signup signup = new Signup();
			BeanUtils.copyProperties(entity,signup);
			signups2.add(signup);
		}
		return signups2;
	}

	@Override
	public Map<String, Object> authUser(String username, String password) {
		Map<String, Object> maps = signupDao.authUser(username, password);
		return maps;
	}

}
