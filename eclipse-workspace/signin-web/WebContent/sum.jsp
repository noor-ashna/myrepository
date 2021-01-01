<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Num</title>
   <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
 <header style="height:36px;background-color: #ff9800;">
 </header>
 
  <div class="container" style="background-image: url('img/download.jpg');height: 543px;">
  
     <img src="https://previews.123rf.com/images/hermandesign2015/hermandesign20151805/hermandesign2015180500163/101798410-font-design-for-word-math-with-student.jpg" 
     style="height: 210px;"/>
  
    <hr/>
    
    <form action="addNum" method="post">
    <label style=" text-decoration: underline;color:blue;font-weight: bold;">Add Number</label>
     <div class="form-group">
        <label style="margin-right: 20px;">Num1</label>
        <input type="text" name="num1" class="form-control" style="width: 60%;display: inline;">
     </div>
     
      <div class="form-group">
        <label style="margin-right: 20px;">Num2</label>
        <input type="text" name="num2" class="form-control" style="width: 60%;display: inline;">
     </div>
      <hr/>
      <div class="form-group">
        <button type="submit" class="btn btn-primary">Calculation!!!!</button>
         <button type="button" class="btn btn-warning">WOW SUB!</button>
         <a href="showHistory"> 
         	<button type="button" class="btn btn-danger">History!</button>
         </a>
     </div>
      <hr/>
      Result is.................. ${yamao0a89282}
      </form>
  </div>

</body>
</html>