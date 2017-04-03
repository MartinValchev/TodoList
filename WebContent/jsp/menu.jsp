<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<title>To Do List Welcome</title>
</head>
<body>
	<%
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("user"));
					String userName = cookie.getValue();
				request.getSession().setAttribute("username", userName);
			}
		}
	%>
	<h2 class="panel-heading">Welcome to My ToDo List Menu</h2>
	<div class="panel-body">
		<p class="text-primary">user: <%=request.getSession().getAttribute("username") %></p>
		<div>
			<form method="post" action="/TodoList/Dispatcher">
				<ul style="list-style-type: none">
					<li><input type="submit" name="taskList"
						value="Pending Tasks List" class="btn btn-default"></li>
					<br>
					<br>
					<li><input type="submit" name="taskCompleted"
						value="Completed Tasks List" class="btn btn-default"></li>
					<br>
					<br>
					<li><input type="submit" name="addTask" value="Add Task" class="btn btn-default"></li>
					<br>
					<br>
					<li><input type="submit" name="deleteTask" value="Delete Task" class="btn btn-default"></li>
					<br>
					<br>
				</ul>
			</form>
		</div>
	</div>

</body>
</html>