<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error Handling Page</title>
</head>
<body>

	<%
		exception.printStackTrace(response.getWriter());
	%>
<hr>
An exception was generated. Details are above.

</body>
</html>