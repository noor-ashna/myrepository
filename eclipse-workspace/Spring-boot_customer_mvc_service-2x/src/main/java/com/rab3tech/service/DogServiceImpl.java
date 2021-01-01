package com.rab3tech.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rab3tech.dao.DogDaoRepository;
import com.rab3tech.dao.SignupDaoRepository;
import com.rab3tech.dao.entity.DogEntity;
import com.rab3tech.dao.entity.SignupEntity;
import com.rab3tech.vo.Dog;

@Service
public class DogServiceImpl implements DogService{
	
	@Autowired
	private DogDaoRepository dogDaoRepository;
	
	@Autowired
	private SignupDaoRepository signupDaoRepository;
	
	@Override
	public List<Dog> findDogs(int pid){
		SignupEntity dogEntity=signupDaoRepository.findById(pid).get();
		List<DogEntity> dogEntityList=dogEntity.getDogs();
		 List<Dog> dogs =new ArrayList<Dog>();
		for(DogEntity ddog :dogEntityList){
			Dog dog =new Dog();
			BeanUtils.copyProperties(ddog, dog);
			//Setting parent id
			dog.setPid(pid);
			dogs.add(dog);
		}
		return dogs;
	}
	
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
		//This parent is from database
		SignupEntity signupEntity=signupDaoRepository.findById(dog.getPid()).get();
		dogEntity.setSignupEntity(signupEntity);
		DogEntity ddogEntity=dogDaoRepository.save(dogEntity);
		return ddogEntity.getDid();
	}

}
