package com.auth;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/showLogins")
public class ShowLoginsServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//UI/UX developer
		try {
			        Connection conn=ConnectionUtils.getConnection();
					//before coming to this page load whole login data
					String sql3="select username,password,role from login_tbl";
					PreparedStatement pstmt=conn.prepareStatement(sql3);
					ResultSet rs=pstmt.executeQuery();
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
				    req.getRequestDispatcher("success.jsp").forward(req, resp);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
