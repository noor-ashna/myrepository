<%@page import="com.auth.DataHistory"%>
<%@page import="java.util.List"%>
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
    
     <marquee scrolldelay="120" direction="right"><p style="font-size: 24px;">Mathematics!!!!!!!!!</p></marquee>            
  <table class="table table-bordered">
    <thead>
      <tr>
        <th>SNO</th>
        <th>Num1</th>
        <th>Num2</th>
        <th>Total</th>
        <th>Time</th>
        <th>Action</th>
      </tr>
    </thead>
    <tbody>
    
    <%!
      int x=100;
    %>
    
    
    <%
    int x=200;
    List<DataHistory> dataHistories=(List<DataHistory>)request.getAttribute("dataHistories");
    int count=1;
    for(DataHistory data : dataHistories){
    %>
      <tr>
        <td><%=count++%></td>
        <td><%=data.getNum1() %></td>
        <td><%=data.getNum2() %></td>
        <td><%=data.getTotal() %></td>
        <td><%=data.getTimestamp()%></td>
        <td>
        <a href="deleteData?ttttt=<%=data.getTotal()%>">
        	<img src="img/del.png" style="height: 25px;">
        </a>
         / 
        <a href="deleteNum?num1=<%=data.getNum1()%>&num2=<%=data.getNum2() %>">
        	<img src="img/unlocked.png	" style="height: 25px;">
        </a>
        </td>
      </tr>
      
      <%
      }
    %>
    </tbody>
  </table>
  
  <marquee scrolldelay="280" direction="up">
  Ahahah : = <%=x%>
  Wowow : = <%=this.x%>
  </marquee>
    
      <div class="form-group">
        <a href="sum.jsp">
        <button type="button" class="btn btn-primary">Add Num!!!!</button>
        </a>
         <button type="button" class="btn btn-warning">WOW SUB!</button>
         <button type="button" class="btn btn-danger">History!</button>
     </div>
  </div>

</body>
</html>