<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Students</title>
</head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
<body>
<div class="container">
	<h2 class="pt-4">All Students</h2>
	<a href="/dorms">Dashboard</a><br>
	<table class="table table-hover mt-3">
		<tr>
			<th>Student</th>
		</tr>
		<c:forEach var="student" items="${students}">
			<tr>
				<td><a href="/students/${student.id}">${student.name}</a></td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>