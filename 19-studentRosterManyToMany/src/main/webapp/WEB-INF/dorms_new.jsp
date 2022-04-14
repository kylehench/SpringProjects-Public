<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Dorm</title>
</head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
<body>
<div class="container">
	<h2 class="pt-4">New Dorm</h2>
	<a href="/dorms">Dashboard</a><br>
	<form:form action="/dorms/create" method="post" class="mt-2" modelAttribute="newDorm">
	  	<form:label path="name">Name:</form:label>
	  	<form:errors path="name" class="text-danger"/>
	  	<form:input type="text" path="name" class="form-control mb-2" />
	  	
	  	<input type="submit" value="Add" class="btn btn-primary" />
	</form:form>
</div>
</body>
</html>