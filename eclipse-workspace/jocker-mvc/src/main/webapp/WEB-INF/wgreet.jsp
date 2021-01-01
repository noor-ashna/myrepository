<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hello MVC</title>
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<header style ="height:30px;background-color:blue;">

<h2>Welcome to spring mvc</h2>

<div class="container">
<img alt="" src="images/college.jpg">
<form action="greet"method="post">
<div class ="form-group">
<label>Enter Name</label>
<!-- when you submit your form, name will go to greet and greet will take name and will add pname then back to jsp -->
<input type ="text"name="name"class="form-control"style="width:60%;"/>
<hr/>
<button type="submit"class="btn btn-primary">Greet</button>
<hr/>
 Hello ${pname}
</div>
</form>


</div>

</header>

</body>
</html>