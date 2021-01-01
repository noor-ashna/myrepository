package com.rab3tech.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rab3tech.controller.SignUp;
import com.rab3tech.dao.SignupDaoRepository;
import com.rab3tech.dao.entity.SignupEntity;

/**
 * 
 * @author javahunk
 * 
 * Service layer is acting as mediator between controller
 * and dao layer so all the conversion of data take place here
 *
 */
@Service
public class SignupServiceImpl implements SignupService {

	@Autowired
	private SignupDaoRepository signupDao;
	
	@Autowired
	private JavaMailSender emailSender;
	
	
	@Override
	@Transactional
	public void updatePassword(int sid,String newPassword){
		                    //JPA->findById   
		SignupEntity entity=signupDao.findById(sid).get();
		//Really it is magic!!!
		entity.setPassword(newPassword);
		
		//Code to send email
		SimpleMailMessage rab3techMessage = new SimpleMailMessage();
		rab3techMessage.setFrom("nagendra.yadav.niit@gmail.com");
		rab3techMessage.setTo(entity.getEmail());
		rab3techMessage.setSubject("Regarding password change!!!!!!!!!!!!!!!!!!!!!!!!");
		rab3techMessage.setText("Dear "+entity.getUsername()+" , your password is changed!!!!");
		emailSender.send(rab3techMessage);
		
	}
	
	@Override
	public SignUp findById(int sid){
		                    //JPA->findById   
		SignupEntity entity=signupDao.findById(sid).get();
		SignUp signUp=new SignUp();
		BeanUtils.copyProperties(entity, signUp);
		return signUp;
	}

	@Override
	public void delete(String sid) {
		SignupEntity entity=signupDao.findById(Integer.parseInt(sid)).get();
		signupDao.delete(entity);
	}

	@Override
	public List<SignUp> findAll() {
		List<SignupEntity>  signUps=signupDao.findAll();
		return convertList(signUps);
	}
	
	private List<SignUp> convertList(List<SignupEntity>  signUps){
		List<SignUp> list=new ArrayList<SignUp>();
		for(SignupEntity entity:signUps){
			SignUp signUp=new SignUp();
			BeanUtils.copyProperties(entity, signUp);
			list.add(signUp);
		}
		return list;
	}

	@Override
	public void save(SignUp signUp) {
		SignupEntity entity=new SignupEntity();
		BeanUtils.copyProperties(signUp, entity);
		signupDao.save(entity);
	}

	@Override
	public List<SignUp> authUser(String username, String password) {
		List<SignupEntity>  signUps=signupDao.findByUsernameAndPassword(username,password);
		return convertList(signUps);
	}
	
}
