<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="regCustomer" method="post">
Name:<input type="text" name=tbName id="tbName"/>
<br>
Email:<input type="email" name="tbemail" id="tbemail"/>
<br>
Mobile:<input type="tel"name="tbMobile" id="tbMobile"/>
<br>
Password:<input type="password" name="tbpas" id="tbpas"/>
<br>
State:
<select name="ddlStates">
<option value="karnataka">KA</option>
<option value="andhraAp"></option>
</select>
<br>
<input type="submit" value="registor"/>



</form>



</body>
</html>