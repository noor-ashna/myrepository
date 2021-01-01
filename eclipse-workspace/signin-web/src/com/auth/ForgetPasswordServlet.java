package com.auth;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/forgetPassword")
public class ForgetPasswordServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		   String username=req.getParameter("username");
		   try {
			    //This much code will delete the data from the below table
				Connection conn=ConnectionUtils.getConnection();
				String sql="select password,role from login_tbl where username=?";
				PreparedStatement pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, username);
				ResultSet rs=pstmt.executeQuery();
				if(rs.next()){
					String password=rs.getString(1);
					String role=rs.getString(2);
					req.setAttribute("password", password);
					req.setAttribute("role", role);
				}else{
					req.setAttribute("message", "Sorry , username is not correct!!!!");
				}
				
		 }catch (Exception e) {
			 e.printStackTrace();
		}
	  //calling another servler which will show current data present in database	 
        req.getRequestDispatcher("forgetPassword.jsp").forward(req, resp);
	}

}
