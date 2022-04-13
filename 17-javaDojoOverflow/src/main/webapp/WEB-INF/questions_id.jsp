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
	<div class="d-flex justify-content-between align-items-center">
		<h2 class="mt-4">${question.question}</h2>
		<a href="/questions">Home</a>
	</div>
	<div class="d-flex align-items-center">
		<h3 class="my-2 me-2">Tags:</h3>
		<c:forEach var="tag" items="${question.tags}" varStatus="loopStatus">
	    	<span class="badge bg-secondary ms-2 mt-1">${tag.name}</span>
		</c:forEach>
	</div>
	<div class="d-flex">
		<table class="table me-3 w-50">
			<tr><th>Answers</th></tr>
			<c:forEach var="answer" items="${question.answers}">
				<tr><td>${answer.answer}</td></tr>
			</c:forEach>
		</table>
		<div class="w-50">
			<h4>Add your answer:</h4>
			<form:form action="/answers/create" method="post" modelAttribute="newAnswer">
				<input type="hidden" name="question_id" value="${question.id}"/>
				<form:errors class="text-danger" path="answer"/>
				<form:input type="text" path="answer" class="form-control mb-2"/>
				<input type="submit" value="Submit" class="btn btn-primary">
			</form:form>
		</div>
	</div>
</div>
</body>
</html>