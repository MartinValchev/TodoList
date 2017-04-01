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
<title>delete Task</title>
</head>
<body>
	<form method="post" action="/TodoList/deleteTaskServlet">
		<h2 class="panel-heading">Delete Task</h2>
		<div class="panel-body">
			<%
				int counter = 0;
			%>
			<select name="taskRecord">
				<c:forEach items="${tasks}" var="task">
					<option><%=++counter%>-${task.taskName}
					</option>
				</c:forEach>
			</select> <br>
			<br> <input type="submit" value="Delete Task">
		</div>
	</form>
</body>
</html>