<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Loop</title>
</head>
<body>

<%!
  //This is called declaration tag
  public int papa(int x){
	 //logic and method name
	 return x*x*x;
  }
%>


 <%
   //scriptlet tag
   for(int x=1;x<=100;x++){
	   %>
   <h1>Hello I am jack!!!!!!!!!!!!!!!!!!!!!<%=x%></h1>
   
     
    <h1>Hello I am jack!!!!!!!!!!<%=x%>!!!!!!!!!!!</h1>
     <h1>Hello I am jack!!!!!!!!!!!<%=x%>!!!!!!!!!!</h1>
      <h1>Hello I am jack!!!!!!!!!<%=x%>!!!!!!<%=papa(x)%>!!!!!!</h1>
           
     <% } %>     

</body>
</html>