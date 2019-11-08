<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
										<div class="form-group">
											<label class="control-label col-sm-2" for="email">Email:</label>
											<div class="col-sm-10">
												<input type="email" class="form-control" name="email" id="email"
												placeholder="Enter email" required="required" />
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-sm-2" for="password">Password:</label>
											<div class="col-sm-10">
												<input type="password" class="form-control" id="password"
												placeholder="Enter password" name="password" required="required"/>
											</div>
										</div>
										<div class="form-group">
											<div class="col-sm-offset-2 col-sm-10">
												<button type="submit" class="btn btn-primary">Submit</button>
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