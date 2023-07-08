<%@page import="java.util.ArrayList"%>
<%@page import="com.hao.model.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>form page</title>

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

	<div class="container col-9 p-5">
		<form action="add" method="post">
			<div>
				<h3>Professor</h3>
				<p>NO : ${giaosu.no}</h3>
				<p>Name : ${giaosu.name}</h3>
				<p>Department : ${giaosu.department}</h3>
			</div>
			
			<input name="noProfessor" type="text" hidden value="${giaosu.no}" class="form-control">
			<div class="mb-3">
				<label class="form-label">NO (MSSV)</label> 
				<input name="noStudent" type="number" class="form-control">
			</div>

			<div class="mb-3">
				<label class="form-label">Name</label> 
				<input name="nameStudent" type="text" class="form-control">
			</div>
			
			<div class="mb-3">
				<label class="form-label">Major</label> 
				<input name="majorStudent" type="text" class="form-control">
			</div>

			<button type="submit" class="btn btn-primary">register</button>
		</form>
		
		
		<h1>Students</h1>
		<table class="table mt-2 border table-hover">
			<thead class="table-light">
				<tr>
					<th scope="col">#</th>
					<th scope="col">Name</th>
					<th scope="col">major</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<%
				List<Student> list = (ArrayList<Student>) request.getAttribute("listStudent");
				for (Student it : list) {
				%>
				<tr>
					<td><%= it.getNo() %></td>
					<td><%= it.getName() %></td>
					<td><%= it.getMajor()%></td>
					<td class="d-flex gap-2" > 
						<form action="delete" method="post"> 
							<input name="noProfessor" type="text" hidden value="${giaosu.no}" class="form-control">
							<input name="noStudent" type="text" hidden value="<%= it.getNo() %>" class="form-control">
							<button type="submit" class="btn btn-danger">delete</button> 
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