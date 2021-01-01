package com.auth;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/showHistory")
public class ShowHistoryServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			Connection conn=ConnectionUtils.getConnection();
			String sql="select num1,num2,total,doe from mathematics_history_tbl";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			
			//List can hold objects
			List<DataHistory> dataHistories=new ArrayList<DataHistory>();
			
			while(rs.next()) {
				int num1=rs.getInt(1);
				int num2=rs.getInt(2);
				int total=rs.getInt(3);
				Timestamp timestamp=rs.getTimestamp(4);
				//Creating an instance of DataHistory
				DataHistory dataHistory=new DataHistory(num1, num2, total, timestamp);
				//adding this object into the list
				dataHistories.add(dataHistory);
			}
			
			//key will be always string
			//value could be anything
			//Adding data into request scope
			//so that we can access the same on the forwarded JSP file
			req.setAttribute("dataHistories", dataHistories);
			
		}catch(Exception ex){
			ex.printStackTrace();
		}

		//Forwarding request to the jsp
		req.getRequestDispatcher("show-history.jsp").forward(req, resp);
	}

}
