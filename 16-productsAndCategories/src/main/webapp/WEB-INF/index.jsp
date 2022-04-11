<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container">
	<h2>Home Page</h2>
	<a href="/products/new">New Product</a><br>
	<a href="/categories/new">New Category</a>
	<hr>
	<table class="table">
	  <tr>
	    <th>Products</th>
	    <th>Categories</th>
	  </tr>
	  <tr>
	  	<td>
			<c:forEach var="product" items="${products}">
		    	<a href="/products/${product.id}">${product.name}</a><br>
			</c:forEach>
	    </td>
	    <td>
			<c:forEach var="category" items="${categories}">
		    	<a href="/categories/${category.id}">${category.name}</a><br>
			</c:forEach>
	    </td>
	  </tr>
	</table>
</div>
</body>
</html>