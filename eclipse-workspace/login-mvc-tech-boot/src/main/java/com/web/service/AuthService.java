package com.web.service;

import java.util.List;

import com.web.controller.ProfileDTO;

public interface AuthService {

	void saveProfile(ProfileDTO dto);

	ProfileDTO findByUsernamePass(String username, String password);

	List<ProfileDTO> findAll();
	void deleteByUsername(String username);

	ProfileDTO findByEmail(String email);

	void updateProfile(ProfileDTO dto);

}
