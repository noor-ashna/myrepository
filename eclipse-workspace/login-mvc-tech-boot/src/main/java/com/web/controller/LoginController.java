package com.web.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.service.AuthService;

@Controller
public class LoginController {
	
	@Autowired
	private AuthService authService;


	@GetMapping({ "/auth", "/", "/wow", "/cake" })
	public String showLoginPage() {
		return "login";
	}
	
	@PostMapping("/esignup")
	public String esignupPost(@ModelAttribute ProfileDTO dto,Model model) {
		authService.updateProfile(dto);
		
		//Show all the records
		List<ProfileDTO> profileDTOs=authService.findAll();
		model.addAttribute("happy", profileDTOs);
		return "signups"; //signups.jsp
	}

	
	@GetMapping("/esignup")
	public String edsignup(@RequestParam String temail,Model model){
		ProfileDTO profileDTO=authService.findByEmail(temail);
		model.addAttribute("profileDTO", profileDTO);
		return "esignup"; //esignups.jsp
	}
	
	@GetMapping("/dsignup")
	public String ddsignup(@RequestParam String username,Model model){
		authService.deleteByUsername(username);
		List<ProfileDTO> profileDTOs=authService.findAll();
		model.addAttribute("happy", profileDTOs);
		return "signups"; //signups.jsp
	}
	
	@GetMapping("/signups")
	public String showSignups(Model model){
		List<ProfileDTO> profileDTOs=authService.findAll();
		model.addAttribute("happy", profileDTOs);
		return "signups"; //signups.jsp
	}
	
	@PostMapping("/signup")
	public String signupPost(@ModelAttribute ProfileDTO dto,Model model) {
		/*String username=request.getParameter("username");
		String password=request.getParameter("password");
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String gender=request.getParameter("gender");
		String mobile=request.getParameter("mobile");
		String photo=request.getParameter("photo");
		String role=request.getParameter("role");
		ProfileDTO dto=new ProfileDTO();
		dto.setEmail(email);
		dto.setGender(gender);
		dto.setMobile(mobile);
		dto.setName(name);
		dto.setPassword(password);
		dto.setSsn(123345);
		dto.setUsername(username);
		dto.setPassword(password);*/
		authService.saveProfile(dto);
		model.addAttribute("message", "Hey! you are not my friend!!");
		return "login"; // /login.jsp
	}


	@PostMapping("/auth")
	public String wowlogin(@RequestParam("username") String username,@RequestParam String password,Model model) {
		//String pk=request.getParameter("papa");
		//String password=request.getParameter("password");
		ProfileDTO profileDTO=authService.findByUsernamePass(username, password);
		if (profileDTO != null) {
			 model.addAttribute("message", "Hey! you are my friend!!");
			 model.addAttribute("profileDTO", profileDTO);
			return "home"; // /home.jsp
		} else {
			 model.addAttribute("message", "Hey! you are not my friend!!");
			return "login"; // /login.jsp
		}
		
	}

}
