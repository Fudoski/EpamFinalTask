<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Hospital: Register patient</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/resource/bootstrap/bootstrap.css">
			<script src="${pageContext.request.contextPath}/resource/bootstrap/jquery-3.4.1.js"></script>
			<script src="${pageContext.request.contextPath}/resource/bootstrap/popper.min.js"></script>
			<script src="${pageContext.request.contextPath}/resource/bootstrap/bootstrap.min.js"></script>
			<script type="text/javascript">
			$(function () {
				$('[data-toggle="tooltip"]').tooltip()
			})
		</script>
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
						<li class="nav-item active"><a class="nav-link" href="${pageContext.request.contextPath}/home">Doctors
							<span class="sr-only">(current)</span>
						</a></li>
						<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/patients">Patients
						</a></li>
					</ul>
					<form class="form-inline my-2 my-lg-0" action="${pageContext.request.contextPath}/logout" method="post">
						<button class="btn btn-outline-danger my-2 my-sm-0" type="submit">Log
						out</button>
					</form>
				</div>
			</nav>
		</header>
		<main class="h-100">
			<section id="cover">
				<div id="cover-caption">
					<div id="container" class="container">
						<div class="row">
							<div class="col-sm-6 offset-sm-3">
								<h1 class="display-4">Doctor info</h1>
								<div class="info-form">
									<form class="form-inlin justify-content-center" action="${pageContext.request.contextPath}/update/doctor" method="post">
										<div class="form-group">
											<label class="control-label col-sm-2" for="email">Email:</label>
											<div class="col-sm-10">
												<input type="email" class="form-control" name="email" id="email"
												placeholder="Enter email" required="required" maxlength="45" data-toggle="tooltip" data-placement="top"
												title="Enter user email adress" value="${doc.login}"/>
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-sm-2" for="password">Password:</label>
											<div class="col-sm-10">
												<input type="password" class="form-control" id="password"
												placeholder="Enter password" name="password" 
											 	maxlength="20" data-toggle="tooltip" 
												data-placement="top" title="Fill in the field" value=""/>
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-sm-2" for="name">Name:</label>
											<div class="col-sm-10">
												<input type="text" class="form-control" id="name"
												placeholder="Enter patient name" name="name" 
												required="required" maxlength="45" 
												pattern="[A-ZА-ЯА-ЩЬЮЯЇІЄҐЁ]{1}[a-zа-яа-щьюяїієґё]*" 
												data-toggle="tooltip" data-placement="top" title="Start with up case letter"
												value="${doc.name }"/>
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-sm-2" for="sname">Surname:</label>
											<div class="col-sm-10">
												<input type="text" class="form-control" id="sname" data-toggle="tooltip" data-placement="top" title="Start with up case letter"
												placeholder="Enter patient surname" name="sname" required="required" maxlength="45" 
												pattern="[a-zA-Zа-яА-Яа-щА-ЩЬьЮюЯяЇїІіЄєҐґёЁ]*" value="${doc.sname}" />
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-sm" for="mname">Middle name:</label>
											<div class="col-sm-10">
												<input type="text" class="form-control" id="mname"
												placeholder="Enter patient middle name" name="mname" required="required" maxlength="45" 
												pattern="[a-zA-Zа-яА-Яа-щА-ЩЬьЮюЯяЇїІіЄєҐґёЁ]*" data-toggle="tooltip" data-placement="top" 
												title="Start with up case letter" value="${doc.mname}" />
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-sm" for="dob">Birthday:</label>
											<div class="col-sm-10">
												<input type="date" class="form-control" id="dob"
												placeholder="Enter patient middle name" name="dob" required="required" 
												value="${doc.dob}" />
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-sm" for="phone">Phone:</label>
											<div class="col-sm-10">
												<input type="text" class="form-control" id="phone"
												placeholder="Enter patient phone" name="phone" required="required" 
												data-toggle="tooltip" name="spec" id="spec" 
												data-placement="top" title="Enter doctor phone number"
												value="${doc.phoneNum}"/>
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-sm" for="spec">spec:</label>
											<div class="col-sm-10">
												<select class="custom-select" required="required" data-toggle="tooltip" name="spec" id="spec" data-placement="top" title="Choose doctor specialization">
													<option value="" disabled selected >${doc.doctorSpecialisation.name}</option>
													<c:forEach items="${speclist}" var="spec">
														<option value="${spec.id}">${spec.name}</option>
													</c:forEach>
												</select>
											</div>
										</div>
										<div class="form-group">
											<div class="col-sm-offset-2 col-sm-10">
												<input type="hidden" class="hide" name="usertype" value="doctor"/>
												<button type="submit" class="btn btn-primary" name="id" value="${doc.id}">Submit</button>
											</div>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</section>
		</main>
	</body>
</html>