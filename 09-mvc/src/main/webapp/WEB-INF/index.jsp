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
	<h2><c:out value="${book.title}" /></h2>
	<p>
		Description: <c:out value="${book.description}" /><br />
		Language: <c:out value="${book.language}" /><br />
		Number of Pages: <c:out value="${book.numberOfPages}" />
	</p>
</div>
</body>
</html>