<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Hospital: main page</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" type="text/css"
			href="./resource/bootstrap/bootstrap.css">
			<script src="./resource/bootstrap/jquery-3.4.1.js"></script>
			<script src="./resource/bootstrap/popper.min.js"></script>
			<script src="./resource/bootstrap/bootstrap.min.js"></script>
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
							<li class="nav-item"><a class="nav-link" href="patients">Patients
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
				<div class="container-fluid">
					<div class="row d-flex justify-content-between">
						<div class="btn-group d-flex" role="group">
							<button type="button" class="btn btn-info" style="border-radius: 0px">Sort
							by</button>
							<button type="button"
							class="btn btn-info dropdown-toggle dropdown-toggle-split"
							style="border-radius: 0px" data-toggle="dropdown"
							aria-haspopup="true" aria-expanded="false"></button>
							<form action="home" method="get">
								<div class="dropdown-menu">
								<button class="dropdown-item ${empty sort or sort eq 'alphabet'? 'text-info':'' }" type="submit" name="sort" value="alphabet">Alphabet</button>
								<button class="dropdown-item ${sort eq 'spec'? 'text-info': ''}" type="submit" name="sort" value="spec">Specialization</button>
								<button class="dropdown-item ${sort eq 'patients'? 'text-info': ''}" type="submit" name="sort" value="patients">Patients</button>
							</div>
							</form>
						</div>
						<form action="newUser" method="get" class="form-inline">
							<input type="hidden" class="hide" name="usertype" value="doctor"/>
							<input type="submit" class="btn btn-success" style="border-radius: 0px" value="Register new"/>
						</form>
					</div>
				</div>
				<div class="table-responsive">
					<form action="doctor/info">
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
								<td>${doc.doctorSpecialisation.name}</td>
								<td>${doc.phoneNum}</td>
								<td>${doc.amountOfPatients}</td>
								<td><button type="submit"
								class="btn btn-outline-dark btn-block" name="id" value="${doc.id}">Edit</button></td>
							</tr>
							<c:set var="i" value="${i+1}" />
							</c:forEach>
						</tbody>
					</table>
					</form>
				</div>
			</main>
		<footer> </footer>
	</body>
</html>