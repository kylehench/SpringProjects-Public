<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dojos</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container">
	<h2 class="mt-4"><c:out value="${dojo.name}"/> Location Ninjas:</h2>
	<table class="table table-hover">
	  <tr>
	    <th>First Name</th>
	    <th>Last Name</th>
	    <th>Age</th>
	  </tr>
	<c:forEach var="ninja" items="${ninjas}">
	  <tr>
	    <td>${ninja.first_name}</td>
	    <td>${ninja.last_name}</td>
	    <td>${ninja.age}</td>
	  </tr>
	</c:forEach>
	</table>
	<div class="mt-4"><a href="/">Home</a></div>
</div>
</body>
</html>