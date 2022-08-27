<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Bean properties</title>
</head>
<body>
	<jsp:useBean id="productBean" class="com.ecommerce.ProductBean"
		scope="session"></jsp:useBean>
	Product Id:
	<jsp:getProperty property="productId" name="productBean" /><br>
	Product Name:
	<jsp:getProperty property="productName" name="productBean" /><br>
	Product Price:
	<jsp:getProperty property="price" name="productBean" /><br>
</body>
</html>