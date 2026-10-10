<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration FormS uccess page</title>
</head>
<body>
	<h1>Success</h1>
	<%
	String name = (String) session.getAttribute("name");
	%>
	<h2>
		Hey<%=name%>,you have successfully registered
	</h2>
</body>
</html>