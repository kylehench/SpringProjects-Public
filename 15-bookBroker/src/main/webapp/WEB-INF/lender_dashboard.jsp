<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Leader Dashboard</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container">
	<div class="d-flex justify-content-between mt-3">
		<div>
			<p>Hello, ${sessionScope.userName}</p>
			<h2>The Book Broker!</h2>
			<p>Available Books to Borrow</p>
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
	    <th>Owner</th>
	    <th>Actions</th>
	  </tr>
	<c:forEach var="book" items="${availableBooks}">
	  <tr>
	    <td>${book.id}</td>
	    <td><a href="books/${book.id}">${book.title}</a></td>
	    <td>${book.author}</td>
	    <td>${book.user.userName}</td>
	    <td>
	    	<c:choose>
			    <c:when test="${sessionScope.userId eq book.user.id}">
					<a href="books/${book.id}/edit">edit</a>
					<a href="books/${book.id}/delete">delete</a>
			    </c:when>
			    <c:otherwise>
					<a href="books/${book.id}/borrow">borrow</a>
			    </c:otherwise>
			</c:choose>
	    </td>
	  </tr>
	</c:forEach>
	</table>
	<p class="my-2">Books I'm Borrowing...</p>
	<table class="table table-hover">
	  <tr>
	    <th>ID</th>
	    <th>Title</th>
	    <th>Author Name</th>
	    <th>Owner</th>
	    <th>Actions</th>
	  </tr>
	<c:forEach var="book" items="${borrowedBy}">
	  <tr>
	    <td>${book.id}</td>
	    <td><a href="books/${book.id}">${book.title}</a></td>
	    <td>${book.author}</td>
	    <td>${book.user.userName}</td>
	    <td><a href="books/${book.id}/return">return</a></td>
	  </tr>
	</c:forEach>
	</table>
	<a href="/books" class="mt-2">All Books</a>
</div>
</body>
</html>