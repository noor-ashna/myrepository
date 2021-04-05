<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "cc" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<title>Signup User!</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
  <header style="height: 30px;background-color: #ff5722;">
  </header>
	
  <div class="container">
  	<h3>Signup Page</h3>
  	<table class="table table-bordered">
    <thead>
      <tr>
        <th>Username</th>
        <th>Email</th>
        <th>Mobile</th>
           <th>Action</th>
      </tr>
    </thead>
    <tbody>
     <cc:forEach items="${happy}" var="mango">
      <tr>
        <td>${mango.username}</td>
      <td>${mango.email}</td>
        <td>${mango.mobile}</td>
        <td><a href="dsignup?username=${mango.username}"><img src="img/delete.png"></a>
         /<a href="esignup?temail=${mango.email}"><img src="img/edit.png"></a>
        </td>
      </tr>
      </cc:forEach>
    </tbody>
  </table>
  	<hr/>
  
  </div>	
	<br/><br/><br/>
</body>
</html>