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
  <header style="height: 30px;background-color: #105ad7;">
  </header>
  
  <div class="container">
    <img src="img/group-png-800_420.png" style="height: 200px;"/>
   <img src="img/students-programs-header-mob.png" style="height: 200px;"/>
   
   <br/>
   <span style="color:red;font-size: 16px;font-weight: bold;">${message}</span>
   <hr/>
   <span style="color:blue;font-size: 16px;">${general}</span>
   <hr/>
   <form action="auth" method="POST">
   <div class="form-group">
      <label>Username</label>
      <input type="text" name="username" class="form-control" style="width: 60%;">
   </div>
     <div class="form-group">
      <label>Password</label>
      <input type="password" name="password" class="form-control" style="width: 60%;">
   </div>
   
      <div class="form-group">
     <button type="submit" class="btn btn-primary">Sign In</button>
      <a href="forgetPassword.jsp">
      <button type="button" class="btn btn-warning">Forget Password</button>
      </a>
        <a href="signup.jsp">
        <button type="button" class="btn btn-danger">Sign Up</button>
        </a>
   </div>
   </form>
  
  </div>
  

</body>
</html>