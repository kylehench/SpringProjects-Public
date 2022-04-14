<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${dorm.name}</title>
</head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
<body>
<div class="container">
	<h2 class="pt-4">${dorm.name} Students</h2>
	<a href="/dorms">Dashboard</a><br>
	<form action="/dorms/assign" method="post" class="mt-2">
		<input type="hidden" name="dorm_id" value="${dorm.id}"/>
		<label for="student_id">Students:</label>
		<select name="student_id" class="form-select mb-2">
		    <option value="none" selected disabled hidden>--- Select an Option ---</option>
		    <c:forEach var="student" items="${all_students}">
	          	<option value="${student.id}">${student.name} <c:if test="${student.dorm != null}">(${student.dorm.name})</c:if></option>
	        </c:forEach>
		</select>
	  	<input type="submit" value="Add" class="btn btn-primary" />
	</form>
	<table class="table table-hover mt-3">
		<tr>
			<th>Student</th>
			<th>Action</th>
		</tr>
		<c:forEach var="student" items="${dorm.students}">
			<tr>
				<td>${student.name}</td>
				<td><a href="/dorms/clearAssignment/${dorm.id}/${student.id}">Remove</a></td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>