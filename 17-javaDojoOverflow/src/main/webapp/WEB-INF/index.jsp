<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Questions Dashboard</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container">
	<h2 class="mt-4">Questions Dashboard</h2>
	<table class="table">
		<tr>
		    <th>Question</th>
		    <th>Tags</th>
		<c:forEach var="question" items="${questions}">
			<tr>
			  	<td>
		    		<a href="/questions/${question.id}">${question.question}</a><br>
			    </td>
			  	<td>
			  		<c:forEach var="tag" items="${question.tags}" varStatus="loopStatus">
				    	${tag.name}<c:if test="${!loopStatus.last}">,</c:if>
					</c:forEach>
			    </td>
			</tr>
		</c:forEach>
	</table>
	<div class="d-flex justify-content-end">
		<a href="/questions/new">New Question</a>
	</div>
</div>
</body>
</html>