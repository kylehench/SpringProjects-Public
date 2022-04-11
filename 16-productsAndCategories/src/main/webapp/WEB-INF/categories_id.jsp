<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Product</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container">
	<h2>${category.name}</h2>
	<a href="/">Home</a><br>
	<hr>
	<h3>Products:</h3>
	<c:forEach var="product" items="${category.products}">
		<ul>${product.name}</ul>
	</c:forEach>
	<hr>
	<h3>Add Product</h3>
	<form:form action="/categories/${category.id}" method="post">
		<input type="hidden" name="_method" value="put">
		<label for="product">Product:</label>
		<select name="product_id" class="form-select mb-2">
		  <option value="none" selected disabled hidden>--- Select an Option ---</option>
		  	<c:forEach var="product" items="${productsNotInCategory}">
				<option value="${product.id}">${product.name}</option>
			</c:forEach>
		</select>
		
		<input type="submit" value="Submit" class="btn btn-primary" />
	</form:form>
	
</div>
</body>
</html>