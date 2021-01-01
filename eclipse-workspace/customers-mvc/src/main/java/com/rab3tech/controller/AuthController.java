package com.rab3tech.controller;

import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

//This is controller
@Controller
public class AuthController {
	
	@Autowired
	private DataSource dataSource;
	
	// method =GET
	// action=auth
	@GetMapping("signup")
	public String signupUser() {
		return "usignup";// login.jsp
	}
	
	@PostMapping("signup")
	public String signupPost(HttpServletRequest request) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String role = request.getParameter("role");
		String photo = request.getParameter("photo");
		//Creating the instance of model
		SignUp signUp=new SignUp();
		signUp.setEmail(email);
		signUp.setGender(gender);
		signUp.setPassword(password);
		signUp.setPhoto(photo);
		signUp.setRole(role);
		signUp.setUsername(username);
		
		//Date must come from java.util package
		Timestamp timestamp=new Timestamp(new Date().getTime());
		
		//Below is spring jdbc programming
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="insert into signup_tbl(username,password,email,gender,role,photo,doe) values(?,?,?,?,?,?,?)";
		Object[] data={username,password,email,gender,role,photo,timestamp};
		jdbcTemplate.update(sql,data);
		
		System.out.println(signUp);
		
		//signUp object we are adding into request scope
		//so that we can access this object on jsp page
		request.setAttribute("signUp", signUp);
		
		request.setAttribute("message", "<span style=\"color:blue\">You have signed up successfully!!!!!!!!</span>");
		return "login";// login.jsp
	}
	
	
	//method =POST
	//action=auth
	@PostMapping("/auth")
	public String authUser(HttpServletRequest request) {
		// request.getParameter is used to read data coming from client!!
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if ("jack".equals(username) && "jill".equals(password)) {
			request.setAttribute("message", "<span style=\"color:green\">You are great!!!!!!!!</span>");
		} else {
			request.setAttribute("message", "<span style=\"color:red\">You are not great!!!!!!!</span>");
		}
		return "login"; //// login.jsp
	}
	
	//method =GET
	//action=auth
	@GetMapping({"/auth","/"})
	public String getAuthUser() {
		return "login";// login.jsp
	}

}
