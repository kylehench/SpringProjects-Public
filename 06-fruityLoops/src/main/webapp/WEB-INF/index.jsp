<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fruit Store</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<div class="container">
		<h2 class="my-3" id="title">Fruit Store</h2>
		<div class="p-4" id="table-wrapper">
			<table class="table table-hover">
			  <tr>
			    <th>Name</th>
			    <th>Price</th>
			  </tr>
			  	<c:forEach var="item" items="${fruits}">
				  <tr>
				    <td><c:out value="${item.getName()}" /></td>
				    <td><c:out value="${item.price}" /></td>
				  </tr>
			  	</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>