<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dorms</title>
</head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
<body>
<div class="container">
	<h2 class="mt-4">Dorms</h2>
	<p>
		<a href="/dorms/new">Add a new dorm</a>
	</p>
	<p>
		<a href="/students/new" class="mt-2">Add a new student</a>
		<br><a href="/students">View all students</a>
	</p>
	<p>
		<a href="/classes/new" class="mt-2">Add a new class</a>
		<br><a href="/classes">View all classes</a>
	</p>
	<table class="table table-hover mt-3">
		<tr>
			<th>Dorm</th>
			<th>Action</th>
		</tr>
		<c:forEach var="dorm" items="${dorms}">
			<tr>
				<td>${dorm.name}</td>
				<td><a href="/dorms/${dorm.id}">See Students</a></td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>