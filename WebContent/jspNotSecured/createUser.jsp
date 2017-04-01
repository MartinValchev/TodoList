<html>
<head>
<meta http-equiv="Content-Type" content="text/html;">
<link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<title>Create User</title>
</head>
<body>
	<div class="panel panel-default">
		<h3 class="panel-heading">User Registration</h3>
		<div class="panel-body">
			<br>
			<form action="/TodoList/addUserServlet" method="post">
				<ul style="list-style-type: none">
					<li class="form-group form-control">First Name: <input
						type="text" name="first_name" maxlength="25">
					</li>
					<br>
					<li class="form-group form-control">Last Name: <input
						type="text" name="last_name" maxlength="25"></li>
					<br>
					<li class="form-group form-control">E-mail:<input type="text"
						name="email"><br>
					</li>
					<br>
					<br>
					<li class="form-group form-control">Telephone: <input
						type="text" maxlength="12" name="telephone"><br>
						</li>
					<br>

					<li class="form-group form-control">Username: <input
						type="text" maxlength="20" name="username"></li>
					<br>

					<li class="form-group form-control">Password: <input
						type="password" maxlength="20" name="password"><br></li>
					</li>
					<br>
					<br>


					<li><input class="btn btn-success" type="submit" value="Login"><input
						type="reset" class="btn btn-info"></li>
				</ul>
			</form>
		</div>
	</div>
		<br><br>
			<p><a href="/TodoList/html/index.html" style="color:yellow;" class="btn btn-primary" >Return to main page</a></p>

	<div class="panel-body">
	<ul style="list-style-type: none">
		<c:forEach items="${errorMessages}" var="errorMessage">
			<li style="color:red;">${errorMessage}</li>
			<br>	
	</c:forEach>
	</ul>
	</div>
</body>
</html>