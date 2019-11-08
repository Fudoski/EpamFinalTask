<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Hospital: main page</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" type="text/css" href="./resource/bootstrap/bootstrap.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		<script src="./resource/bootstrap/bootstrap.min.js"></script>
	</head>
	<body>
		<header>
			<nav class="navbar navbar-expand-lg navbar-light bg-light ">
			  <span class="navbar-brand mb-0 h1">Hospital</span>
				<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav mr-auto " >
						<li class="nav-item active">
							<a class="nav-link" href="#">Doctors <span class="sr-only">(current)</span></a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="#">Patients </a>
						</li>
					</ul>
					<form class="form-inline my-2 my-lg-0" action="logout" method="post">
						<button class="btn btn-outline-danger my-2 my-sm-0" type="submit">Log out</button>
					</form>
				</div>
			</nav>
		</header>
		<main>
		</main>
		<footer>
			
		</footer>
	</body>
</html>