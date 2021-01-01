package com.rab3tech.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rab3tech.dao.DogDaoRepository;
import com.rab3tech.dao.entity.DogEntity;
import com.rab3tech.vo.Dog;

@Service
public class DogServiceImpl implements DogService{
	
	@Autowired
	private DogDaoRepository dogDaoRepository;
	
	@Override
	public Dog findById(int did){
		DogEntity dogEntity=dogDaoRepository.findById(did).get();
		Dog dog=new Dog();
		BeanUtils.copyProperties(dogEntity, dog);
		return dog;
	}
	
	@Override
	public int save(Dog dog){
		DogEntity dogEntity=new DogEntity();
		BeanUtils.copyProperties(dog, dogEntity);
		DogEntity ddogEntity=dogDaoRepository.save(dogEntity);
		return ddogEntity.getDid();
	}

}
