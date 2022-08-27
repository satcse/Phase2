<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Session Logout</title>
</head>
<body>
<%
	session.invalidate();
%>
<b>Your session has been terminated</b><br>
<a href="index.jsp">Login again</a>
</body>
</html>