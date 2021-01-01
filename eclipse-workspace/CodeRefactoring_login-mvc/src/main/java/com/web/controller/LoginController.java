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
import com.web.dao.SignupDao;
import com.web.service.SignupService;

@Controller
public class LoginController {

	@Autowired
	private SignupService signupService;

	@PostMapping("/usignup")
	public String updateSignup(@ModelAttribute Signup signup, Model model) {
		signupService.update(signup);
		model.addAttribute("message", "You have updated your record successfully!!!!!!!!!!!!!!!!!!!!!");
		return "redirect:/signups"; // gsignup.jsp
	}

	@PostMapping("/signup")
	public String postSignup(@ModelAttribute Signup signup, Model model) {
		signupService.save(signup);
		model.addAttribute("message", "You have signed up successfully!!!!!!!!!!!!!!!!!!!!!");
		return "login"; // gsignup.jsp
	}

	@GetMapping("/deleteSignup")
	public String deleteSignupData(@RequestParam String username) {
		signupService.delete(username);
		return "redirect:/signups"; /// WEB-INF/pages/signups.jsp
	}

	@GetMapping("/editSignup")
	public String editSignupData(@RequestParam String username, Model model) {
		Signup signup = signupService.findByUsername(username);
		model.addAttribute("signup", signup);
		return "esignup"; /// WEB-INF/pages/signups.jsp
	}

	@GetMapping("/signups")
	public String showAllData(Model model) {
		model.addAttribute("dsignups", signupService.findAll());
		return "signups"; /// WEB-INF/pages/signups.jsp
	}

	@GetMapping("/signup")
	public String showSignupPage() {
		return "gsignup"; /// WEB-INF/pages/gsignup.jsp
	}

	@GetMapping({ "/auth", "/", "/wow", "/cake" })
	public String showLoginPage() {
		return "login";
	}

	@PostMapping("/auth")
	public String wowlogin(@RequestParam String username, @RequestParam String password, Model model) {
		Map<String, Object> mapsdata = signupService.authUser(username, password);
		if (mapsdata.size() > 0) {
			model.addAttribute("data", mapsdata);
			model.addAttribute("message", "Hey! you are my friend!!");
		} else {
			model.addAttribute("message", "Hey! you are not my friend!!");

		}
		return "login"; // /login.jsp
	}

}
