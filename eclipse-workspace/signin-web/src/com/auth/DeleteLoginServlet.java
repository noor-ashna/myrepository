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


// <a href="deleteData?ttttt=<%=data.getTotal()%>">
@WebServlet("/deleteLogin")
public class DeleteLoginServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 String username=req.getParameter("username");
		 try {
			    //This much code will delete the data from the below table
				Connection conn=ConnectionUtils.getConnection();
				String sql="delete from login_tbl where username=?";
				PreparedStatement pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, username);
				pstmt.executeUpdate();
		 }catch (Exception e) {
			 e.printStackTrace();
		}
	
	  //calling another servler which will show current data present in database	 
      req.getRequestDispatcher("showLogins").forward(req, resp);
		
	}

}
