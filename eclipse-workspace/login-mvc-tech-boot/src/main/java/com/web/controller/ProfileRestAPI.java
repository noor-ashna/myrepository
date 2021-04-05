package com.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.web.service.AuthService;
//why rest controller - >> to create or accept raw data
@RestController
@RequestMapping("/v4")
public class ProfileRestAPI {
	
	
	@Autowired
	private AuthService authService;
	
	//JSON data coming in the request
	//@RequestBody ->> this takes raw data from in coming request and map to java object
	//GET
	//POST
	//PUT
	//DELETE
	//PATCH
	@PostMapping("/signups")
	public AppResponse postProfile(@RequestBody ProfileDTO profileDTO){
	    authService.saveProfile(profileDTO);
	    AppResponse appResponse=new AppResponse();
	    appResponse.setCode("200");
	    appResponse.setMessage("profile is uploaded successfully!");
	    //{"code:"200","message":"profile is uploaded successfully!"}
		return appResponse; 
	}
	
	@PutMapping("/signups")
	public AppResponse updateProfile(@RequestBody ProfileDTO profileDTO){
	    authService.updateProfile(profileDTO);
	    AppResponse appResponse=new AppResponse();
	    appResponse.setCode("200");
	    appResponse.setMessage("profile is update successfully!");
	    //{"code:"200","message":"profile is uploaded successfully!"}
		return appResponse; 
	}
	
	//{username}" ->> means sending data as a part of URI
	@DeleteMapping("/signups/{jocker}")
	public AppResponse deleteSignups(@PathVariable("jocker") String username) {
		authService.deleteByUsername(username);
		AppResponse appResponse = new AppResponse();
		appResponse.setCode("200");
		appResponse.setMessage("profile is deleted successfully!");
		return appResponse;
	}
	
	@GetMapping("/signups")
	public List<ProfileDTO> showSignups(){
		List<ProfileDTO> profileDTOs=authService.findAll();
		return profileDTOs; //signups.jsp
	}

	@GetMapping("/esignup")
	public ProfileDTO edsignup(@RequestParam String temail){
		ProfileDTO profileDTO=authService.findByEmail(temail);
		return profileDTO; //esignups.jsp
	}

}
