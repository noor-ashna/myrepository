<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "wow" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Auth</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
	<header style="height: 30px; background-color: #ff5722;"> </header>
	<div class="container">
	<img src="img/pic.jpg" style="height: 120px"> <br /> <a
	
			href="auth">
			<button type="button" class="btn btn-success">Sign In</button>
		</a>
		<hr />
		<p>All info</p>
		<table class="table table-dark table-hover">
			<thead>
				<tr>
					<th>username</th>
					<th>password</th>
					<th>email</th>
					<th>gender</th>
					<th>role</th>
					<th>doe</th>
					<th>Action</th>
					
				</tr>
			</thead>
			<tbody>
			<wow:forEach var="item" items="${mysignUps}">
				<tr>
					<td>${item.username}</td>
					<td>${item.password}</td>
					<td>${item.email}</td>
					<td>${item.gender}</td>
					<td>${item.role}</td>
					<td>${item.doe}</td> 
					<td>
					<a href= "deleteSignup?sid=${item.sid}"title="Click to delete">
					<img src="img/delete.png" style = "height:30px;">
					</a>
					</td>
				</tr>
				</wow:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>