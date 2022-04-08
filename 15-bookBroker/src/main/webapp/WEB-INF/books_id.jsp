<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Share</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container">
	<div class="d-flex justify-content-between mt-3">
		<div>
			<h2><c:out value="${book.title}"/></h2>
			<c:choose>
			    <c:when test="${sessionScope.userId eq book.user.id}">
					<p>You read <b>${book.title}</b> by <b>${book.author}</b>.<br>Here are your thoughts:</p>
			    </c:when>
			    <c:otherwise>
					<p>${book.user.userName} read <b>${book.title}</b> by <b>${book.author}</b>.<br>Here are ${book.user.userName}'s thoughts:</p>
			    </c:otherwise>
			</c:choose>
		</div>
		<div class="d-flex flex-column justify-content-center align-items-end">
			<a href="/logout">Logout</a>
			<a href="/books">Back to the shelves</a>
		</div>
	</div>
	<hr>
	<p>${book.thoughts}</p>
	<hr>
    <c:if test="${sessionScope.userId eq book.user.id}">
	<div class="d-flex justify-content-end"><a href="/books/${book.id}/edit"><button type="button" class="btn btn-secondary">Edit</button></a></div>
	</c:if>
</div>
</body>
</html>