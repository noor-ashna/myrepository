package com.auth;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/auth")
public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		
		try {
			//Step-1 ->>Loading the driver
			//2002
			Connection conn=ConnectionUtils.getConnection();
			String sql="select role from login_tbl where username=? and password=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){ //This condition will execute once username and password are correct!
				String crole=rs.getString(1);
				//This session is user specific
				HttpSession session=req.getSession();
                //seconds!!!				
				session.setMaxInactiveInterval(30);
				session.setAttribute("username", username);
				session.setAttribute("role", crole);
				
				req.setAttribute("crole", crole);
				if(crole.equalsIgnoreCase("admin")){
					//before coming to this page load whole login data
					String sql3="select username,password,role from login_tbl";
					pstmt=conn.prepareStatement(sql3);
					rs=pstmt.executeQuery();
					List<Auth> auths=new ArrayList<Auth>(); 
					while(rs.next()){ //
						//fetching one row data
						String name=rs.getString(1);
						String pass=rs.getString(2);
						String role=rs.getString(3);
						//setting one row data into one java object
						Auth auth=new Auth();
						auth.setPassword(pass);
						auth.setRole(role);
						auth.setUsername(name);
						//that java object , I am adding into list
						auths.add(auth);
					}
					//Why I am adding list into request scope
					//cauths key could be anything but always string type
					req.setAttribute("cauths", auths);
				}
				
				req.getRequestDispatcher("success.jsp").forward(req, resp);
			}else{
				//if username and password are not correct
				//I want to go to the login page
				//key will be always string
				//value could be anything
				req.setAttribute("message", "Hey! username and password are not correct!");
				req.setAttribute("general", "This is general message!");
				req.getRequestDispatcher("login.jsp").forward(req, resp);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
