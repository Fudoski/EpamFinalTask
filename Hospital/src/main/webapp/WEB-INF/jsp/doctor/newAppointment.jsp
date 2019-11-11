<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ex" uri="/WEB-INF/tag/sub.tld"%>
<!DOCTYPE html>
<html>
	<head>
	<title>Hospital: main page</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css"	href="${pageContext.request.contextPath}/resource/bootstrap/bootstrap.css">
	<script src="${pageContext.request.contextPath}/resource/bootstrap/jquery-3.4.1.js"></script>
	<script src="${pageContext.request.contextPath}/resource/bootstrap/popper.min.js"></script>
	<script src="${pageContext.request.contextPath}/resource/bootstrap/bootstrap.min.js"></script>
	<script type="text/javascript">
		function addMedicine() {
			var tbody = document.getElementById('medicine');
			var btn = document.getElementById('amb');
			var tr = document.createElement('tr');
			var inpt = document.createElement('input');
			inpt.setAttribute('type','text');
			inpt.setAttribute('class','form-control');
			inpt.setAttribute('name','newmed');
			inpt.setAttribute('placeholder','enter medicine...');
			inpt.setAttribute('required','required');
			var td = document.createElement('td');
			td.setAttribute('scope', 'row');
			td.appendChild(inpt);
			tr.appendChild(td);
			tbody.insertBefore(tr,btn);
		}

		function addProcedure() {
			var tbody = document.getElementById('procedure');
			var btn = document.getElementById('apb');
			var tr = document.createElement('tr');
			var inpt = document.createElement('input');
			inpt.setAttribute('type','text');
			inpt.setAttribute('class','form-control');
			inpt.setAttribute('name','newproc');
			inpt.setAttribute('placeholder','enter procedure...');
			inpt.setAttribute('required','required');
			var td = document.createElement('td');
			td.setAttribute('scope', 'row');
			td.appendChild(inpt);
			tr.appendChild(td);
			tbody.insertBefore(tr,btn);
		}
	</script>
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
	<main>
		<section id="cover">
			<div id="cover-caption">
				<div id="container" class="container">
					<div class="row">
						<div class="col">
							<h1 class="display-4">Назначение</h1>
							<div class="info-form">
								<form class="form-inlin justify-content-center" action="${pageContext.request.contextPath}/newAppointment" method="post">
									<div class="container-fluid border border-dark rounded mb-4 mt-2">
										<!-- DOCTOR INFO -->
										<div class="row bg-light">
											<!-- doc full name-->
											<div class="col-4">
												DOCTOR:
											</div>
											<div class="col-4">
												Фамилия Инициалы
											</div>
											<div class="col-4">
												Хирург
											</div>
										</div>
										<div class="row">
											<div class="col">
												<input type="text" name="diagnosis" class="form-control" placeholder="enter patient diagnosis..." name="diagnosis" required="required">
											</div>
										</div>
										<!-- MEDICINE LIST -->
										<div class="row">
											<div class="col bg-success text-white" >
												<p class="font-weight-bold">MEDICINE LIST</p>
											</div>
										</div>
										<div class="row">
											<table class="table table-sm">
												<tbody id="medicine">
													<tr id='amb'>
														<td scope="row"><button type="button" class="btn btn-primary rounded-circle" onclick="addMedicine()"><span class="font-weight-bold">+</span></button></td>
													</tr>
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
												<tbody id="procedure">
													<tr id='apb'>
														<td scope="row"><button type="button" class="btn btn-primary rounded-circle" onclick="addProcedure()"><span class="font-weight-bold">+</span></button></td>
													</tr>
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
										<div class="row bg-light mt-2">
											<div class="col"> 
												<input type="text" name="opdescription" class="form-control" />
											</div>
										</div>
										<div class="row mt-2">
											<div class="col">
												<div class="form-group">
													<button type="submit" name="id" value="${pID}" class="btn btn-outline-secondary">Назначить</button>
												</div>
											</div>
											<div class="col">
												<div class="form-check">
												    <input type="checkbox" class="form-check-input" id="exampleCheck1" name="discharge">
												    <label class="form-check-label" for="exampleCheck1">Discharge</label>
												</div>
											</div>
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