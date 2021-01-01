package com.web.controller.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//POJO -2006
//POJI
public class Signup {
	
	private String username;
	private String password;
	private String name;
	private String email;
	private String gender;
	private String role;
	private String photo;
    
	
}
