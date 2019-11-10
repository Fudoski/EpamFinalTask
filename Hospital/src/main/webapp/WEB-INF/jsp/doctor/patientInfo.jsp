<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ex" uri="/WEB-INF/tag/sub.tld"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Hospital: patient med card</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/resource/bootstrap/bootstrap.css">
			<script src="${pageContext.request.contextPath}/resource/bootstrap/jquery-3.4.1.js"></script>
			<script src="${pageContext.request.contextPath}/resource/bootstrap/popper.min.js"></script>
			<script src="${pageContext.request.contextPath}/resource/bootstrap/bootstrap.min.js"></script>
		</head>
		<body>
		<header>
			<nav class="navbar navbar-expand-lg navbar-light bg-light sticky-top">
				<span class="navbar-brand mb-0 h1">Hospital</span>
				<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav mr-auto ">
						<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/home">Patients
						</a></li>
					</ul>
					<form class="form-inline my-2 my-lg-0" action="logout" method="post">
						<button class="btn btn-outline-danger my-2 my-sm-0" type="submit">Log
						out</button>
					</form>
				</div>
			</nav>
		</header>
		<section>
			<div class="container-fluid">
				<form action="newAppointment" method="get" class="form-inline">
					<button type="submit" class="btn btn-success mb-1 mt-2"  name="id" value="${p.id}">Register new</button>
				</form>
			</div>
		</section>
		<section>
			<div class="container-fluid">
				<div class="row">
					<!-- MAIN -->
					<main class="col-md-8 col-lg-9" style="padding-right: 1px">
						<!-- APPOINTMENT -->
						<c:forEach items="${p.card.appointments}" var="appment" >
							<div class="container-fluid border border-dark rounded mb-4 mt-2">
							<!-- APPOINTMENT ID -->
							<div class="row">
								<div class="col bg-dark text-white" >
									<p class="font-weight-bold">Num of appointment #<c:out value="${appment.id}"></c:out> </p>
								</div>
							</div>
							<!-- DOCTOR INFO -->
							<div class="row bg-light">
								<!-- doc full name-->
								<div class="col-2">
									DOCTOR:
								</div>
								<div class="col-2">
									<ex:sub doctor="${doc}"></ex:sub>
								</div>
								<div class="col-3">
									<p>Spec:${doc.doctorSpecialisation.name}</p>
								</div>
							</div>
							<div class="row bg-white">
								<p><c:out value="${appment.diagnosis}"></c:out> </p>
							</div>
							<!-- MEDICINE LIST -->
							<div class="row">
								<div class="col bg-success text-white" >
									<p class="font-weight-bold">MEDICINE LIST</p>
								</div>
							</div>
							<div class="row">
								<table class="table table-sm">
									<thead class="thead-light">
										<tr>
											<th scope="col">description</th>
											<th scope="col">complete</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${appment.medList}" var="med">
											<tr>
												<td scope="row"><c:out value="${med.discription}"></c:out></td>
												<td><c:out value="${med.medStaffID}"></c:out></td>
											</tr>
										
										</c:forEach>
									</tbody>
								</table>
							</div>
							<!-- PROCEDURE LIST -->
							<div class="row">
								<div class="col bg-info text-white" >
									<p class="font-weight-bold">PROCEDURE LIST</p>
								</div>
							</div>
							<div class="row">
								<table class="table table-sm">
									<thead class="thead-light">
										<tr>
											<th scope="col">Описание процедуры</th>
											<th scope="col">Выполнил</th>
										</tr>
									</thead>
									<tbody>
									<c:forEach items="${appment.procList}" var="proc">
										<tr>
											<td scope="row"><c:out value="${proc.discription}"></c:out></td>
											<td><c:out value="${proc.medStaffID}"></c:out> </td>
										</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
							<!-- OPERATION INFO -->
							<div class="row">
								<div class="col bg-warning	 text-white" >
									<p class="font-weight-bold">Операция</p>
								</div>
							</div>
							<!-- OPERATION DESCRIPTION -->
							<div class="row bg-light">
								<div class="col-2">
									Описание:
								</div>
								<div class="col-10">
									<c:out value="${appment.operation.discription}"></c:out>
								</div>
							</div>
							<div class="row bg-dark" style="height: 3px">
								<p></p>
							</div>
							<div class="row bg-light">
								<!-- doc full name-->
								<div class="col-2">
									Доктор:
								</div>
								<div class="col-4">
									Бибик А.В.
								</div>
								<div class="col-6">
									Специальность: хирург
								</div>
							</div>
						</div>
						</c:forEach>
						
					</main>
					<!-- ASIDE -->
					<div class="col-md-4 col-lg-3 border border-info rounded" >
						<div class="container-fluid" style="padding: 0px">
							<div class="row bg-primary text-white">
								<h1 class="display-4">Patient info</h1>
							</div>
							<div class="row">
								<form class="form-inlin justify-content-center w-100" action="newUser" method="post">
									<div class="form-group col">
										<label class="col bg-light" for="name">Name:</label>
										<div class="col">
											<input type="text" class="form-control-plaintext" name="name" id="name" value="${p.name}" />
										</div>
									</div>
									<div class="form-group col">
										<label class="col bg-light" for="sname">Surname:</label>
										<div class="col">
											<input type="text" class="form-control-plaintext" name="sname" id="sname" value="${p.sname}" />
										</div>
									</div>
									<div class="form-group col">
										<label class="col bg-light" for="mname">Middle name:</label>
										<div class="col">
											<input type="text" class="form-control-plaintext" name="mname" id="mname" value="${p.mname}" />
										</div>
									</div>
									<div class="form-group col">
										<label class="col bg-light" for="dob">Birthday:</label>
										<div class="col">
											<input type="text" class="form-control-plaintext" name="dob" id="dob" value="p.dob" />
										</div>
									</div>
									<div class="form-group col" >
										<label class="col bg-light" for="phone">Phone:</label>
										<div class="col">
											<input type="hidden" name="id" value="${p.id}"/>
											<input type="text" class="form-control-plaintext" name="phone" id="phone" value="${p.phoneNum}" />
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
	</body>
</html>