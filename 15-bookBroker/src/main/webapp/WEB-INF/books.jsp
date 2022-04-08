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
			<h2>Welcome, <c:out value="${userName}"/></h2>
			<p>Books from everyone's shelves:</p>
		</div>
		<div class="d-flex flex-column justify-content-center align-items-end">
			<a href="/logout">Logout</a>
			<a href="/books/new">+ Add a book to my shelf!</a>
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
	    <td><a href="books/${book.id}">${book.title}</a></td>
	    <td>${book.author}</td>
	    <td>${book.user.userName}</td>
	  </tr>
	</c:forEach>
	</table>
	<a href="/bookmarket" class="mt-3">Book Market</a>
</div>
</body>
</html>