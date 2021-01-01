<%@page import="java.util.ArrayList"%>
<%@page import="com.auth.Auth"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <title>Login Page</title>
   <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
  <header style="height: 30px;background-color: #105ad7;color:white;font-weight: bold;">
  !!!!!!!!!!!! Hey! Mr. ${sessionScope.username}${username}
  </header>
  
  <div class="container">
    <img src="img/group-png-800_420.png" style="height: 200px;"/>
   <img src="img/students-programs-header-mob.png" style="height: 200px;"/>
   <hr/>
   <a href="showLogins">Show Logins</a>
   <h4>Hello your current role is  <span style="color:blue;font-weight: bold;">${crole}</span></h4>
   
     <p>
     <img src="img/signup.png" style="height: 70px;">
     All Signup data!</p>            
  <table class="table table-bordered">
    <thead>
      <tr>
      <th>SNo</th>
        <th>Username</th>
        <th>Password</th>
        <th>Role</th>
          <th>Action</th>
      </tr>
    </thead>
    <tbody>
     <%
     List<Auth> auths=(List<Auth>)request.getAttribute("cauths");
     if(auths==null){
    	 auths=new ArrayList<Auth>();
     }
     int count=1;
     for(Auth auth:auths){
     %>
      <tr>
        <td><%=count++%></td>
        <td><%=auth.getUsername()%></td>
        <td><%=auth.getPassword()%></td>
          <td><%=auth.getRole()%></td>
          <td>
            <a href="deleteLogin?username=<%=auth.getUsername()%>">
            <img alt="" src="img/delete.png" style="height: 35px;">
            </a>
            /
            <img alt="" src="img/edita.png">
          </td>
      </tr>
      
      <%
     }
      %>
      
      
    </tbody>
    </table>
   
  </div>
  

</body>
</html>