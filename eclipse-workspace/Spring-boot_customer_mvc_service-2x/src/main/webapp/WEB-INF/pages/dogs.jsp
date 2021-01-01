<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "tea" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Auth</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
  <header style="height: 30px;background-color: #e91e63;">
  
  </header>
  
  <div class="container">
  	 <h2>Auth Container</h2>
  	 <img src="img/student.png" style="height:180px;">
  	  <img src="img/images.jpg" style="height:180px;">
  	 
  	 <hr/>
  	 <a href="auth">
<button type="button" class="btn btn-primary">Sign In</button>
</a>
  	 <hr/>
  	  <p>All Dogs!:</p>            
  <table class="table table-dark table-hover">
    <thead>
      <tr>
        <th>Name</th>
        <th>Color</th>
        <th>Email</th>
        <th>Tail</th>
        <th>Breed</th>
        <th>Photo</th>
        <th>Action</th>
      </tr>
    </thead>
    <tbody>
    
    <tea:forEach var="item" items="${crydogs}">
      <tr>
        <td>${item.name}
        </td>
        <td>${item.color}</td>
        <td>${item.email}</td>
       <td>${item.tail}</td>
       <td>${item.breed}</td>
       <td>coming soon</td>
        <td>TODO!!!</td>
      </tr>
      </tea:forEach>
    </tbody>
  </table>
  	 
  
  </div>
 
</body>
</html>