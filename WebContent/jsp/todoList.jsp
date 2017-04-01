<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<title>ToDo List</title>
</head>
<body>
	<h2 class="panel-heading">ToDo List</h2>
	<div class="panel-body">
		<%
			int counter = 0;
		%>
		<table border="1" cellspacing="0" class="table table-hover table-responsive">
			<tr>
				<th>No.</th>
				<th>Task Name</th>
				<th>Due Date</th>
				<th>Description</th>
			</tr>
			<c:forEach items="${tasks}" var="task">
				<tr>
					<td><%=++counter%></td>
					<td>${task.taskName}</td>
					<td>${task.dueDate}</td>
					<td>${task.description}</td>
				</tr>
			</c:forEach>
		</table>
		<br></br>
		<form action="/TodoList/jsp/menu.jsp" method="get">
			<input type="submit" value="return to Main Menu">
		</form>
	</div>
</body>
</html>