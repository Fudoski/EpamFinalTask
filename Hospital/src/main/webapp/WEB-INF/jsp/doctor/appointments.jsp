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
							<li class="nav-item"><a class="nav-link" href="home">Patients
							</a></li>
							<li class="nav-item active"><a class="nav-link" href="appointments">Appointments
							<span class="sr-only">(current)</span>
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
					<!-- MEDICINES -->
					<c:forEach items="${medModelList}" var="mml">
					<div class="row  mt-2 mb-2">
						<div class="container">
							<div class="row">
								<div class="col-7">
									<form class=" border rounded">
										<div class="form-group row ml-0 mr-0">
											<label for="staticEmail" class="col-4 col-form-label bg-light-">Пациент</label>
											<div class="col-8">
												<input type="text" readonly class="form-control-plaintext" id="staticEmail" value="${mml.pSname} ${mml.pName} ${mml.pMname}">
											</div>
										</div>
										<div class="form-group row ml-0 mr-0">
											<label for="staticDoctor" class="col-4 col-form-label">Доктор</label>
											<div class="col-8">
												<input type="text" readonly class="form-control-plaintext" id="staticDoctor" value="${mml.docSname} ${mml.docName} ${mml.docMname}">
											</div>
										</div>
										<div class="form-group row ml-0 mr-0">
											<label for="staticDoctor" class="col-4 col-form-label">Описание</label>
											<div class="col-8">
												<input type="text" readonly class="form-control-plaintext" id="staticDoctor" 
												value="${mml.medicineDesc}">
											</div>
										</div>
										<div class="form-group row ml-0 mr-0">
											<div class="col-8">
												<button type="submit" class="btn btn-outline-success">Выполнить</button>
											</div>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
					</c:forEach>
					<!-- PROCEDURES -->
					<c:forEach items="${procModelList}" var="pml">
						<div class="row mt-2 mb-2">
						<div class="container">
							<div class="row">
								<div class="col-7">
									<form class=" border rounded-lg">
										<div class="form-group row ml-0 mr-0">
											<label for="staticEmail" class="col-4 col-form-label">Пациент</label>
											<div class="col-8">
												<input type="text" readonly class="form-control-plaintext" id="staticEmail" value="${pml.pSname} ${pml.pName} ${pml.pMname}">
											</div>
										</div>
										<div class="form-group row ml-0 mr-0">
											<label for="staticDoctor" class="col-4 col-form-label">Доктор</label>
											<div class="col-8">
												<input type="text" readonly class="form-control-plaintext" id="staticDoctor" value="${pml.docSname} ${pml.docName} ${pml.docMname}">
											</div>
										</div>
										<div class="form-group row ml-0 mr-0">
											<label for="staticDoctor" class="col-4 col-form-label">Описание</label>
											<div class="col-8">
												<input type="text" readonly class="form-control-plaintext" id="staticDoctor" 
												value="${pml.procDesc}">
											</div>
										</div>
										<div class="form-group row ml-0 mr-0">
											<div class="col-8">
												<button type="submit" class="btn btn-outline-info">Выполнить</button>
											</div>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
					</c:forEach>
					<!-- OPERATIONS -->
					<div class="row  mt-2 mb-2">
						<div class="container">
							<div class="row">
								<div class="col-7">
									<form class=" border  rounded">
										<div class="form-group row ml-0 mr-0">
											<label for="staticEmail" class="col-4 col-form-label">Пациент</label>
											<div class="col-8">
												<input type="text" readonly class="form-control-plaintext" id="staticEmail" value="Бибик А.В.">
											</div>
										</div>
										<div class="form-group row ml-0 mr-0">
											<label for="staticDoctor" class="col-4 col-form-label">Доктор</label>
											<div class="col-8">
												<input type="text" readonly class="form-control-plaintext" id="staticDoctor" value="Бибик А.В.">
											</div>
										</div>
										<div class="form-group row ml-0 mr-0">
											<label for="staticDoctor" class="col-4 col-form-label">Описание</label>
											<div class="col-8">
												<input type="text" readonly class="form-control-plaintext" id="staticDoctor" 
												value="3 капли антистресса">
											</div>
										</div>
										<div class="form-group row ml-0 mr-0">
										<div class="col-8">
											<button type="submit" class="btn btn-outline-danger">Выполнить</button>
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