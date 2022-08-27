<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP EL Example</title>
</head>
<body>
<%
	List<String> names = new ArrayList<String>();
	names.add("Pankaj");names.add("David");
	pageContext.setAttribute("names", names);
%>

<strong>pageContext EL Example:</strong> HTTP Method is ${pageContext.request.method}
<br><br>
<strong>Context param EL Example:</strong> ${initParam.AppID}
<br><br>
<strong> PageContext Data: </strong><%= pageContext.getAttribute("names") %>
<strong>Arithmetic Operator EL Example:</strong> ${initParam.AppID + 200}
<br><br>
<strong>Relational Operator EL Example:</strong> ${initParam.AppID < 200}
<br><br>
<strong>Arithmetic Operator EL Example:</strong> ${initParam.AppID * 200}
<br><br>

</body>
</html>