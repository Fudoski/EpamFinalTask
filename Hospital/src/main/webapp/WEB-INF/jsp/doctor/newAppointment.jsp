<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ex" uri="/WEB-INF/tag/sub.tld"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hospital: Authorization</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="./resource/bootstrap/bootstrap.css"/>
<link rel="stylesheet" type="text/css" href="./resource/css/login.css">
</head>
	<body>
		<main class="h-100">
			<section id="cover">
				<div id="cover-caption">
					<div id="container" class="container">
						<div class="row">
							<div class="col-sm-6 offset-sm-3">
								<h1 class="display-4">Authorization</h1>
								<div class="info-form">
									<form class="form-inlin justify-content-center" action="login" method="post">
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