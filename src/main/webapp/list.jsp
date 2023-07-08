<%@page import="java.util.ArrayList"%>
<%@page import="com.hao.model.Professor"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>list page</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
	crossorigin="anonymous"></script>
</head>
<body>
	<div class="container pt-5">
	
		<h1>Professors</h1>
		<table class="table mt-2 border table-hover">
			<thead class="table-light">
				<tr>
					<th scope="col">#</th>
					<th scope="col">Name</th>
					<th scope="col">Department</th>
					<th scope="col"  >Action</th>
				</tr>
			</thead>
			<tbody>
				<%
				List<Professor> list = (ArrayList<Professor>) request.getAttribute("listProfessor");
				for (Professor it : list) {
				%>
				<tr>
					<td><%= it.getNo() %></td>
					<td><%= it.getName() %></td>
					<td><%= it.getDepartment() %></td>
					<td class="d-flex gap-2" > 
						<form action="info" method="post"> 
							<button type="submit" class="btn btn-info" name="noProfessor" value="<%= it.getNo() %>" >Info</button> 
						</form> 
					</td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</div>
</body>
</html>