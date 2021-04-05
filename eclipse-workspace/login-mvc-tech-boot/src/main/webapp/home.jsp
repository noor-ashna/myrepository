<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<title>User Home!!!!!!!!!!!!!!!!!</title>
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
  	<img src="img/login.png" style="height: 164px">
  	 <span style="color:red;font-weight: bold;">${message}</span>
  	<img src="img/jcoker.png">
  	
  	<hr/>
  	 <h2>This page is under construction!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!</h2>
  	 <h2>Username : ${profileDTO.username}</h2>
  	 <h2>Name : ${profileDTO.name}</h2>
  	 <h2>Email : ${profileDTO.email}</h2>
  	 <h2>Mobile : ${profileDTO.mobile}</h2>
  	 <h2>Gender : ${profileDTO.gender}</h2>
  
  	<hr/>
  
  </div>	
	<br/><br/><br/>
</body>
</html>