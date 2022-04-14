<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Classes</title>
</head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
<body>
<div class="container">
	<h2 class="pt-4">All Classes</h2>
	<a href="/dorms">Dashboard</a><br>
	<table class="table table-hover mt-3">
		<tr>
			<th>Class</th>
		</tr>
		<c:forEach var="course" items="${courses}">
			<tr>
				<td><a href="/classes/${course.id}">${course.name}</a></td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>