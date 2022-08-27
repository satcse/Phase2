<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP Action Tags</title>
</head>
<body>

	<b>Usage of useBean Tags</b>
	<jsp:useBean id="productBean" class="com.ecommerce.ProductBean"
		scope="session"></jsp:useBean>
	<jsp:setProperty property="productId" name="productBean" value="18791" />
	<jsp:setProperty property="productName" name="productBean"
		value="Optical Wireless Mouse" />
	<jsp:setProperty property="price" name="productBean" value="600.00" />

	<a href="showbean.jsp">Access bean properties from another page</a>
	<br>
	<a href="forward.jsp">Use forward action to go to Google</a>
	<br>
	<hr>

	<jsp:text>
		<![CDATA[This is my content.<br/> This will show within a text action tag exactly as it was entered.]]>
	</jsp:text>
</body>
</html>