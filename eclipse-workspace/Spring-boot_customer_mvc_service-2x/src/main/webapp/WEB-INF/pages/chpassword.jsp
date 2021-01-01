<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Change Password!!!</title>
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
  	 <h2>Change Password</h2>
  	 <img src="img/student.png" style="height:180px;">
  	  <img src="img/images.jpg" style="height:180px;">
  	  
  	  <br/>
  	  <b>${message}</b>
  	 <hr/>
  	 
  	 <form action="changePassword" method="post">
  	 <input type="hidden" value="${signUp.sid}" name="sid" class="form-control">
  	 	 <div class="form-group">
  	 	 	<label>Username</label>
  	 	 	<input type="text" readonly="readonly" value="${signUp.username}" name="username" class="form-control" style="width: 70%;">
  	 	 </div>
  	 	 
  	 	 	 <div class="form-group">
  	 	 	<label>New Password</label>
  	 	 	<input type="password" name="newPassword" class="form-control" style="width: 70%;">
  	 	 </div>
  	 	 
  	 	 <div class="form-group">
  	 	 	<label>Confirm Password</label>
  	 	 	<input type="password" name="confirmPassword" class="form-control" style="width: 70%;">
  	 	 </div>
  	 	 	 <div class="form-group">
  	 	 	<br/>
  	 	 	<button type="submit" class="btn btn-primary">Change Password</button>
  	 	 </div>
  	 </form>
  	 
  	 <hr/>
  </div>
 
</body>
</html>