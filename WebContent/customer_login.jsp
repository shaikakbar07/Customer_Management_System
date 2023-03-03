<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>customer </title>
</head>
<body>
	<h1> Customer Login page</h1>
	
	<form action="logCustomer" method="post">
	<label for="tbEmail">Email:</label>
	
	<input type="email" name="tbEmail" id="tbEmail" value="<%= request.getParameter("tbemail")%>"/>
	<br>
	
	<label for="tbpass">password:</label>
	<input type="password" name="tbpass" id="tbpass" value="<%= request.getParameter("tbpas")%>"/>
	<br>
	
	
	<input type ="submit" value="Login">
	</form>

</body>

</html>