<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login and Registration</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container">
	<div class="d-flex justify-content-between mt-3">
		<div>
			<h2>Welcome, <c:out value="${user.userName}"/></h2>
			<p>This is your dashboard. Nothing to see yet.</p>
		</div>
		<div class="d-flex flex-column">
			<a href="/logout" class="ml-auto">Logout</a><br>
			<a href="/books/new" class="ml-auto">+ Add a book to my shelf!</a>
		</div>
	</div>
	<table class="table table-hover">
	  <tr>
	    <th>ID</th>
	    <th>Title</th>
	    <th>Author Name</th>
	    <th>Posted By</th>
	  </tr>
	<c:forEach var="book" items="${books}">
	  <tr>
	    <td>${book.id}</td>
	    <td>${book.title}</td>
	    <td>${book.author}</td>
	    <td>${book.user.userName}</td>
	  </tr>
	</c:forEach>
	</table>
</div>
</body>
</html>