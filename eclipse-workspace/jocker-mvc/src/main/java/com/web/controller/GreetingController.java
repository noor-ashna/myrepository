package com.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetingController {
	
	// Method=Get, action ="greet"
	@GetMapping("/greet")
	public String welcome(HttpServletRequest req) {
		String name =req.getParameter("name");
	  // we are adding name into request scope(HttpServletRequest is request scope)
	 // which we can access later on jsp file
		req.setAttribute("pname", name); // pname we can access on jsp file
		
		return "greet";
	}

}
