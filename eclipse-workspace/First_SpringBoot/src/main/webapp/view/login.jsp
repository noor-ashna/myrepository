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
	<header style="height: 30px; background-color: #00ff9c;"> </header>
	<div class="container">
		<marquee> <h2>Practice until you can't get it wrong</h2>  </marquee>
		<img src="img/pic.jpg" style="height: 120px"> <br /> <b>
			${message} </b>
			
		<hr />
		<form action="auth" method="post">
			<div class="form-group">
				<label>Username</label> <input type="text" name="username"
					class="form-control" style="width: 60%;">
			</div>
			<div class="form-group">
				<label>Password</label> <input type="password" name="password"
					class="form-control" style="width: 60%;">
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-primary">Auth User</button>
				<a href="signup">
					<button type="button" class="btn btn-secondary">Sign up</button>
				</a>
				<a href="psignups">
					<button type="button" class="btn btn-info">Show all records</button>
				</a>
			</div>
		</form>
		           
  <table class="table table-dark"> 
    <thead>
      <tr>
        <th>username</th>
        <th>password</th>
        <th>email</th>
         <th>gender</th>
          <th>role</th>
            <th>doe</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>${signup.username}</td>
        <td>${signup.password}</td>
        <td>${signup.email} </td>
        <td>${signup.gender} </td>
        <td>${signup.role} </td>
        <td>${signup.doe} </td>
        
      </tr>
    </tbody>
  </table>
	</div>
</body>
</html>