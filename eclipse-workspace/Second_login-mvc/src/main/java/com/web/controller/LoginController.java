package com.web.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.controller.vo.Signup;

@Controller
public class LoginController {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@PostMapping("/signup")
	public String postSignup(@ModelAttribute Signup signup,Model model) {  // we use @ModelAttribute and Signup object, we do not need all
		//Here we have to write the code to push data into database!!!     // the following code 
		/*String username=req.getParameter("username");
		String password=req.getParameter("password");
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String gender=req.getParameter("gender");
		String role=req.getParameter("role");
		String photo=req.getParameter("photo");
		Signup signup=new Signup(username,password,name,email,gender,role,photo);*/
		
		//db columns name and pojo attributes name could be different
		String sql="insert into user_profiles_tbl (username,password,role,name,email,gender,photo) values(?,?,?,?,?,?,?)";
		Object[] data={signup.getUsername(),signup.getPassword(),signup.getRole(),signup.getName(),signup.getEmail(),signup.getGender(),signup.getPhoto()};
		jdbcTemplate.update(sql,data);
		model.addAttribute("message", "You have signed up successfully!!!!!!!!!!!!!!!!!!!!!");
		// Hey! go to login page
		return "login"; // gsignup.jsp
	}
	
	
	@GetMapping("/signups")
	public String showAllData(Model model){
		//Fetch All the data before going to this page
		String sql="select lid,username,password,role,name,email,gender,photo from user_profiles_tbl";
		List<Signup> dsignups=jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Signup.class));
		//Add all the list into request scope so that same can be accessed on jsp
		model.addAttribute("dsignups", dsignups);
		return "signups"; ///WEB-INF/pages/signups.jsp
	}
	
	@GetMapping("/signup")
	public String showSignupPage(){
		return "gsignup"; ///WEB-INF/pages/gsignup.jsp
	}
	
	//One resource can be mapped with more than one url pattern!!!!
	@GetMapping({"/auth","/","/wow","/cake"})
	public String showLoginPage(){
		return "login";
	}
	//Method - POST
	//Action - /auth
	@PostMapping("/auth")
	public String wowlogin(@RequestParam String username,@RequestParam String password,Model model){ // @RequestParam can be used instead of 
		/*String username=req.getParameter("username");                                              // HttpServletRequest req
		String password=req.getParameter("password");*/
		String sql="select username,password,role,name,email,gender,photo from user_profiles_tbl where username=? and password=?";
		try {
			Map<String,Object> mapsdata=jdbcTemplate.queryForMap(sql, username,password);
			model.addAttribute("data", mapsdata);
			model.addAttribute("message","Hey! you are my friend!!");
		}catch (DataAccessException e) {
			model.addAttribute("message","Hey! you are not my friend!!");
		}
		return "login"; // /login.jsp
	}

}
