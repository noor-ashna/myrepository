package com.huge.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
	
	@Autowired                       // using another bean @Bean("pkdataSource")
	private DataSource dataSource;
	
	@GetMapping("deleteSignup")
	public String deleteSignup(HttpServletRequest request) {
		String sid =request.getParameter("sid");
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);   
		String sql = "delete from signup_tbl where sid="+sid;
		jdbcTemplate.update(sql);	
		return "redirect:/psignups";  
	}
	@GetMapping("psignups")
	public String showSignups(HttpServletRequest request) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);   
		String sql = "select sid,username, password,email,gender, role, doe from signup_tbl";
		List<SignUp> signUps=jdbcTemplate.query(sql,new BeanPropertyRowMapper(SignUp.class));	
		request.setAttribute("mysignUps",signUps);
		return "signups"; // signups.jsp
	}

	@GetMapping("signup")
	public String signupUser() {
		
		return "usignup";
	 }
	@PostMapping("signup")
	public String signupPost(HttpServletRequest request) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String role = request.getParameter("role");
		SignUp signup = new SignUp();
		signup.setUsername(username);
		signup.setPassword(password);
		signup.setEmail(email);
		signup.setGender(gender);
		signup.setRole(role); 
		// Data must come from java.util package
		Timestamp timestamp= new Timestamp(new Date().getTime());
		// below is spring jdbc programming 
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);   
		String sql = "insert into signup_tbl( username, password,email,gender, role, doe)values(?,?,?,?,?,?)";
		Object[] data= {username, password, email, gender, role,timestamp};
		jdbcTemplate.update(sql,data);
		System.out.println(signup);
		// signup object we are adding into request scope
		// so that we can access this object on jsp page
		request.setAttribute("signup",signup);
		request.setAttribute("message","You have signed up successfully");
		return "login";	
}
	@PostMapping("/auth")
	public String authUserController(HttpServletRequest request) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if ("jack".equals(username) && "jill".equals(password)) {
			request.setAttribute("message", "Successfully login!!");
		} else {
			request.setAttribute("message", "Sorry, you entered wrong username or password");
		}
		return "login";
	}

	@GetMapping({"/auth","/"})
	public String getAuthUser() {
		return "login";
	}

}
