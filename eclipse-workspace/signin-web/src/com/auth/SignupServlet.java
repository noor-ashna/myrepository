package com.auth;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		String role=req.getParameter("role");
		try {
			//Step-1 ->>Loading the driver
			//2002
			Connection conn=ConnectionUtils.getConnection();
			String ssql="select role from login_tbl where username=?";
			PreparedStatement pstmt=conn.prepareStatement(ssql);
			pstmt.setString(1, username);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				req.setAttribute("message", "Hey, Sorry "+username+" already registered with us!!");
				req.getRequestDispatcher("signup.jsp").forward(req, resp);
			}else{
				String sql="insert into login_tbl values(?,?,?)";
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, username);
				pstmt.setString(2, password);
				pstmt.setString(3, role);
				pstmt.executeUpdate();
				req.setAttribute("message", "Ahaha! you have registered successfully with us!");
				req.getRequestDispatcher("login.jsp").forward(req, resp);	
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
