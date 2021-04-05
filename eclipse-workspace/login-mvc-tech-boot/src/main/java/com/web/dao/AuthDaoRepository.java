package com.web.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

public interface AuthDaoRepository extends JpaRepository<ProfileEntity, Integer> {

	ProfileEntity findByUsernameAndPassword(String username, String password);
	
	@Modifying
	void deleteByUsername(String username);
	
	ProfileEntity findByEmail(String email);
}
