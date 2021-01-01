package com.auth;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Do not forget to write slash /
@WebServlet("/addNum")
public class AddNumServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String num1=req.getParameter("num1");
		String num2=req.getParameter("num2");
		int n1=Integer.parseInt(num1);
		int n2=Integer.parseInt(num2);
		int sum=n1+n2;
		
		//This code is pushing data into database...
		Date date=new Date();
		//milliseconds
		long time=date.getTime();
		Timestamp timestamp=new Timestamp(time);
		try {
			Connection conn=ConnectionUtils.getConnection();
			String sql="insert into mathematics_history_tbl values(?,?,?,?)";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,n1);
			pstmt.setInt(2,n2);
			pstmt.setInt(3,sum);
			pstmt.setTimestamp(4, timestamp);
			pstmt.executeUpdate();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		//adding request into request scope and forward request the jsp
		req.setAttribute("yamao0a89282", sum);
		
		//Hey! forward my request to the JSP
		req.getRequestDispatcher("sum.jsp").forward(req, resp);
	}
}
