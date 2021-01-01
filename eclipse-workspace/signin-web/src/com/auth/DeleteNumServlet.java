package com.auth;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// <a href="deleteData?ttttt=<%=data.getTotal()%>">
@WebServlet("/deleteNum")
public class DeleteNumServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 String num1=req.getParameter("num1"); //it is always return String
		 String num2=req.getParameter("num2");
		 try {
			    //This much code will delete the data from the below table
				Connection conn=ConnectionUtils.getConnection();
				String sql="delete from mathematics_history_tbl where num1=? and num2=?";
				PreparedStatement pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, Integer.parseInt(num1));
				pstmt.setInt(2, Integer.parseInt(num2));
				//insert , delete, update
				pstmt.executeUpdate();
		 }catch (Exception e) {
			 e.printStackTrace();
		}
	
	  //calling another servler which will show current data present in database	 
      req.getRequestDispatcher("showHistory").forward(req, resp);
		
	}

}
