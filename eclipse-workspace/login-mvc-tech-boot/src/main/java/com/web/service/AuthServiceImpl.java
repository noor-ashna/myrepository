package com.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.controller.ProfileDTO;
import com.web.dao.AuthDaoRepository;
import com.web.dao.ProfileEntity;

@Service
public class AuthServiceImpl implements AuthService {
	
	@Autowired
	private AuthDaoRepository authDao;
	
	@Override
	public List<ProfileDTO> findAll(){
		List<ProfileEntity> profileList=authDao.findAll();
		//List<ProfileEntity>  we have to convert into List<ProfileDTO>
		List<ProfileDTO> list=new ArrayList<ProfileDTO>();
		for(ProfileEntity entity:profileList){
			ProfileDTO profileDTO=new ProfileDTO();
			BeanUtils.copyProperties(entity, profileDTO);
			list.add(profileDTO);
		}
		return list;
	}
	
	@Override
	public ProfileDTO findByEmail(String email){
		ProfileEntity entity=authDao.findByEmail(email);
			ProfileDTO profileDTO=new ProfileDTO();
			BeanUtils.copyProperties(entity, profileDTO);
		return profileDTO;
	}

	@Override
	public void saveProfile(ProfileDTO dto) {
		//what we are doing here???
		//we are copying data from ProfileDTO type into ProfileEntity
		ProfileEntity entity=new ProfileEntity();
		BeanUtils.copyProperties(dto, entity);
		authDao.save(entity);
	}

	@Override
	public ProfileDTO findByUsernamePass(String username, String password) {
		ProfileEntity profileEntity=authDao.findByUsernameAndPassword(username, password);
		ProfileDTO profileDTO=new ProfileDTO();
		BeanUtils.copyProperties(profileEntity, profileDTO);
		return profileDTO;
	}

	@Override
	public void deleteByUsername(String username) {
		authDao.deleteByUsername(username);
	}

	@Override
	public void updateProfile(ProfileDTO dto) {
		ProfileEntity entity=new ProfileEntity();
		BeanUtils.copyProperties(dto, entity);
		authDao.save(entity);
	}
}
