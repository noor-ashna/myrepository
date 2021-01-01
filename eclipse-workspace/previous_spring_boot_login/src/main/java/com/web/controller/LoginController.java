package com.web.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.controller.vo.RoleVO;
import com.web.controller.vo.Signup;
import com.web.controller.vo.SignupHistoryVO;
import com.web.service.LoginService;
import com.web.service.RoleService;
import com.web.service.SignupService;
import com.web.util.DateUtils;

@Controller
public class LoginController {

	@Autowired
	private SignupService signupService;
	
	@Autowired
	private LoginService loginService;
	

	@Autowired
	private RoleService roleService;
	
	
	@PostMapping("/changeRole")
	public String changeRolesPost(@RequestParam int lid,@RequestParam String srole,Model model) {
		
		signupService.updateRoles(lid, srole);
		
		return "redirect:/signups";
	}
	
	
	@GetMapping("/changeRole")
	public String changeRoles(@RequestParam String username,Model model) {
		List<RoleVO> roleVOs=roleService.findAll();
		model.addAttribute("roleVOs",roleVOs);
		Signup signup=signupService.findByUsername(username);
		List<RoleVO> sroleVOs=signup.getRoleVOs();
		//I am setting selected true for the current role of the customer
		for(RoleVO roleVO:roleVOs){
			 if(sroleVOs.contains(roleVO)){
				 roleVO.setSelected(true);
			 }
		}
		model.addAttribute("signup",signup);
		return "changeRoles"; /// WEB-INF/pages/signups.jsp
	}

	@PostMapping("/usignup")
	public String updateSignup(@ModelAttribute Signup signup, Model model) {
		signupService.update(signup);
		model.addAttribute("message", "You have updated your record successfully!!!!!!!!!!!!!!!!!!!!!");
		return "redirect:/signups"; // make a new request
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
	
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		if(session!=null){
			session.invalidate();
		}
		return "redirect:auth?message=Hmmmmmm logout!!!!"; /// WEB-INF/pages/gsignup.jsp
	}


	@PostMapping("/auth")
	public String wowlogin(@RequestParam String username, @RequestParam String password,HttpSession session, Model model) {
		Map<String, Object> mapsdata = signupService.authUser(username, password);
		if (mapsdata.size() > 0) {
			SignupHistoryVO historyVO=new SignupHistoryVO();
			session.setMaxInactiveInterval(10);
			session.setAttribute("username", username);
			session.setAttribute("email", "technohunk100@gmail.com");
			historyVO.setUsername(username);
			historyVO.setIntime(DateUtils.getCurrentTime());
			historyVO.setLocation("India!!!!");
			int shid=loginService.saveHistory(historyVO);
			session.setAttribute("shid", shid);
			model.addAttribute("data", mapsdata);
			model.addAttribute("message", "Hey! you are my friend!!");
		} else {
			model.addAttribute("message", "Hey! you are not my friend!!");
		}
		return "redirect:/signups"; // /login.jsp
	}

}
