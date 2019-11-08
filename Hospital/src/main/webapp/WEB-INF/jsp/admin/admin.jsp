<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Hospital: main page</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css"
	href="./resource/bootstrap/bootstrap.css">
<script src="./resource/bootstrap/bootstrap.min.js"></script>
<script src="./resource/bootstrap/jquery-3.4.1.js"></script>
<script src="./resource/bootstrap/popper.min.js"></script>
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-lg navbar-light bg-light ">
			<span class="navbar-brand mb-0 h1">Hospital</span>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto ">
					<li class="nav-item active"><a class="nav-link" href="#">Doctors
							<span class="sr-only">(current)</span>
					</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Patients
					</a></li>
				</ul>
				<form class="form-inline my-2 my-lg-0" action="logout" method="post">
					<button class="btn btn-outline-danger my-2 my-sm-0" type="submit">Log
						out</button>
				</form>
			</div>
		</nav>
	</header>
	<main>
	<div class="">
		<div class="btn-group">
			<button type="button" class="btn btn-info" style="border-radius: 0px">Sort
				by</button>
			<button type="button"
				class="btn btn-info dropdown-toggle dropdown-toggle-split"
				style="border-radius: 0px" data-toggle="dropdown"
				aria-haspopup="true" aria-expanded="false"></button>
			<div class="dropdown-menu">
				<a class="dropdown-item text-info" href="#">Specialization</a> <a
					class="dropdown-item" href="#">Patients</a>
			</div>
		</div>
	</div>
	<div class="table-responsive">
		<table class="table table-sm table-hover">
			<thead class="thead-dark">
				<tr>
					<th scope="col">#</th>
					<th scope="col">Name</th>
					<th scope="col">Surname</th>
					<th scope="col">Middlename</th>
					<th scope="col">Specialization</th>
					<th scope="col">Phone</th>
					<th scope="col">Patiens</th>
					<th scope="col"></th>
				</tr>
			</thead>
			<tbody>
				<c:set var="i" value="1" />
				<c:forEach items="${doctorlist}" var="doc">
					<tr>
						<th scope="row"><c:out value="${i}" /></th>
						<td>${doc.name}</td>
						<td>${doc.sname}</td>
						<td>${doc.mname}</td>
						<td>${doc.doctorSpecialisation}</td>
						<td>${doc.phoneNum}</td>
						<td>${doc.amountOfPatients}</td>
						<td><button type="button"
								class="btn btn-outline-dark btn-block">Edit</button></td>
					</tr>
					<c:set var="i" value="${i+1}" />
				</c:forEach>
			</tbody>
		</table>
	</div>
	</main>
	<footer> </footer>
</body>
</html>