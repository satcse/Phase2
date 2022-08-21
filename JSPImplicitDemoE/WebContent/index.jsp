<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP Implicit Objects</title>
</head>
<body>

<%
	String responseCheck = request.getParameter("office");
	if(responseCheck!= null)
	{
		response.setStatus(response.SC_MOVED_TEMPORARILY);
		response.setHeader("Location", "response-redirect.jsp?office="+responseCheck);
	}
	String errorCheck = request.getParameter("error");
	if(errorCheck!=null)
	{
		int x=0;
		if(x==0)
			throw new RuntimeException("Exception has occured");
	}
%>
<%

	int serverPort=request.getServerPort();
	out.println("The Server is running on port"+ String.valueOf(serverPort)+"<br>");
	out.println("Servlet Name is"+config.getServletName()+"<br>");
	out.println("Server Info:"+application.getServerInfo()+"<br>");
	
	String pageName = page.toString();
	out.println("The name of the page: "+pageName);
	
	pageContext.setAttribute("userid", "Sathish");
	out.println("UserID attribute from Page Context is: "+pageContext.getAttribute("userid")+"<br>");	
%>
<a href="index.jsp?office=head_office">Show usage of response object</a><br>
<a href="index.jsp?error=1">Show usage of error Object</a><br>

<%
	if(response.containsHeader("Office"))
		out.println("Current Location is"+response.getHeader("Office"));
%>
</body>
</html>