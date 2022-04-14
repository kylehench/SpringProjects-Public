<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${student.name}</title>
</head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
<body>
<div class="container">
	<h2 class="pt-4">${student.name}'s Classes</h2>
	<a href="/dorms">Dashboard</a><br>
	<form action="/students/assignClass" method="post" class="mt-2">
		<input type="hidden" name="student_id" value="${student.id}"/>
		<label for="course_id">Classes:</label>
		<select name="course_id" class="form-select mb-2">
		    <option value="none" selected disabled hidden>--- Select an Option ---</option>
		    <c:forEach var="course" items="${courses}">
	          	<option value="${course.id}">${course.name}</option>
	        </c:forEach>
		</select>
	  	<input type="submit" value="Add" class="btn btn-primary" />
	</form>
	<table class="table table-hover mt-3">
		<tr>
			<th>Class Name</th>
			<th>Action</th>
		</tr>
		<c:forEach var="course" items="${student.courses}">
			<tr>
				<td><a href="/classes/${course.id}">${course.name}</a></td>
				<td><a href="/students/clearClass/${student.id}/${course.id}">Drop</a></td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>