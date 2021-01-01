package com.auth;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionListener;

@WebFilter("/showLogins")
public class SessionFilter implements Filter{

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest=(HttpServletRequest)arg0;
		//Ask for session
		HttpSession session=httpServletRequest.getSession(false);
		//then check session has username attribute 
		if(session!=null && session.getAttribute("username")!=null){
			//Go Ahead
			chain.doFilter(arg0,arg1);
		}else{
			//Go to login page
			httpServletRequest.getRequestDispatcher("login.jsp").forward(arg0, arg1);
		}
	}

	
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	
	
}
