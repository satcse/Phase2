<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP Sessions</title>
</head>
<body>
<%
if(request.getParameter("error")!=null)
	out.println("<b>Your session has expired or is invalid");
%>
<form action="login.jsp" method="get">
Name: <input name="name" id="name" maxlength=40><br>
Password: <input type="password" name="pwd" id="pwd" maxlength="10"><br>
<button>Submit</button>
 </form>
</body>
</html>