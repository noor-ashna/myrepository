package com.rab3tech.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rab3tech.dao.entity.SignupEntity;

public interface SignupDaoRepository extends JpaRepository<SignupEntity, Integer> {
	
	/*@Query("from SignupEntity s where s.username=?1 and s.password=?2")
	public List<SignupEntity> authUser(String username,String password);*/
	
	public List<SignupEntity> findByUsernameAndPassword(String username,String password);

}
