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
	<h2>New Product</h2>
	<a href="/">Home</a><br>
	<hr>
	<form:form action="/products/create" method="post" modelAttribute="newProduct">
		<form:label path="name">Name:</form:label>
		<form:errors path="name"/>
		<form:input type="text" path="name" class="form-control mb-2" />
		<form:label path="description">Description:</form:label>
		<form:errors path="description"/>
		<form:input type="text" path="description" class="form-control mb-2" />
		<form:label path="price">Price:</form:label>
		<form:errors path="price"/>
		<form:input type="text" path="price" class="form-control mb-2" />
		
		<input type="submit" value="Submit" class="btn btn-primary" />
	</form:form>
</div>
</body>
</html>