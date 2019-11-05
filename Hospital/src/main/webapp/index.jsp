<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" />
<link rel="stylesheet" href="./css/style.css" />
<link rel="stylesheet" href="./bootstrap/bootstrap.css"/>
<title>Hospital: Authorization</title>
</head>
<body>

	<body>
		<header>
		</header>
		<main>
			<div class="container">
				<form class="form-center" action="login" method="post">
					<h2>Authorization</h2>
					<div class="form-group">
						<label class="control-label col-sm-2" for="email">Email:</label>
						<div class="col-sm-10">
							<input type="email" class="form-control" name="email" id="email" placeholder="Enter email" required="required"/>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="password">Password:</label>
						<div class="col-sm-10">
							<input type="password" class="form-control" id="password" placeholder="Enter password" name="password" required="/">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-primary">Submit</button>
						</div>
					</div>
				</form>
			</div>
		</main>
		<footer>
			
		</footer>
	</body>
</body>
</html>