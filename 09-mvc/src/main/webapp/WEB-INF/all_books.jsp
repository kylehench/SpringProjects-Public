<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container">
	<h1>All Books</h1>
	<table class='table table-hover'>
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Language</th>
            <th>Number of Pages</th>
        </tr>
        <c:forEach var="book" items="${books}">
	        <tr>
	        	<td>${book.id}</td>
	        	<td><a href="/books/${book.id}">${book.title}</a></td>
	        	<td>${book.language}</td>
	        	<td>${book.numberOfPages}</td>
	        </tr>
        </c:forEach>
	</table>
</div>
</body>
</html>