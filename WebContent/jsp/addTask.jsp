<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<title>Add Task</title>
</head>
<body>
	<div class="panel panel-default">
		<h2 class="panel-heading">Add Task</h2>
		<%--http://localhost:8085/ToDoList/addTaskServlet--%>
		<div class="panel-body">
			<form method="post" action="/TodoList/addTaskServlet">
				Task Name: <input type="text" name="task_name"><br>
				<br> Due Date:<input type="date" name="due_date"
					value="YYYY-mm-dd"><br>
				<br> Description:<input type="text" name="description"><br>
				<br> <input type="submit" value="submit">
			</form>
		</div>
	</div>
</body>
</html>