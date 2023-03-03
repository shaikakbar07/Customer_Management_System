<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import= " com.palle.util.Successjsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
Successjsp spJSP = (Successjsp)request.getAttribute("successDetails");

%>
   <header>
      <h1><%= spJSP.h1 %></h1>
   </header>
   
   <p> <%= spJSP.p %></p>
   
   <footer>
      <h3> <%= spJSP.h3 %></h3>
   </footer>
</body>
</html>