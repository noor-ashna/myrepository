/*package com.web.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;

//Spring data + JPA makes your application implementation less
//means no implementation for dao at all
public interface AuthDao {

	public ProfileEntity findByUsernameAndPassword(String username, String password);
	
	@Modifying
	public void deleteByUsername(String username);
	
	public Optional<ProfileEntity> findByEmail(String email);

}
*/