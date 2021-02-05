

<!DOCTYPE html>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@page import="java.util.*"%>

<meta http-equiv="content-type" content="text/html" charset="ISO-8859-1" />

<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Gray</title>
<link rel="icon" type="image/x-icon" href="assets/img/favicon.ico" />
<!-- Font Awesome icons (free version)-->
<!-- Google fonts-->
<link href="https://fonts.googleapis.com/css?family=Varela+Round"
	rel="stylesheet" />
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="css/styles.css" rel="stylesheet" />
</head>
<body id="page-top">



	<!-- Masthead-->
	<header class="header">

		<!-- Navigation-->
		<nav class="navbar navbar-expand-lg navbar-light fixed-top"
			id="mainNav">
			<div class="container">
				<a class="navbar-brand js-scroll-trigger" href="#page-top">Start</a>


				<div class="collapse navbar-collapse" id="navbarResponsive">




		
		
		

					<ul class="navbar-nav ml-auto">
					
				
					
					
					
				
							
						
							
							
						<li class="nav-item"><a class="nav-link js-scroll-trigger"
							href="#bustop">bus stop</a></li>
							
							<form action = "<%= request.getContextPath()%>/login" method = "get">
							
							
					
				<li class="nav-item"><a class="nav-link js-scroll-trigger"
							href="login.jsp">	Logout</a></li>
					
					</form>		
							
							
						
					</ul>
				</div>
			</div>
		</nav>


	</header>



	<!-- About-->
	<section class="about-section text-center" id="about">

		<div class="row">



			<div class="col-md-4">
				<img class="img-fluid img-thumbnail" alt="profile-img"
					src="assets/img/blob.png">
				<hr>


				<h4 class="text-white-50 mx-auto mt-2 mb-5">Bob Blob</h4>
			</div>
			
			<div class="col-md-6">

				<p class="text-white-50 mx-auto mt-2 mb-5">Bob Blob just
					finished work for the day. He wants to know how long he has to
					wait for the next bus that takes him home. We are going to let Bob know
					how many minutes are left for the next departure. That way Bob needs not stay out in the cold 
					any unnecessary minutes</p>



			</div>
		</div>

	</section>


	<section class="signup-section" id="bustop">
		<div class="container">
			<div class="row">
				<div class="col-md-10 col-lg-8 mx-auto text-center">

					<p class="text-white-100">Choose your favourite bus stop for
						the city of Malmö</p>

					<form action="traffic" method="post">


						<select name="station">
							<option value="80000">Central Station</option>
							<option value="80120">Södervärn</option>
							<option value="80140">Triangeln</option>
							<option value="80040">Hyllie</option>
							<option value="80110">Värnhem</option>

						</select>

						<button type="submit" class="btn btn-primary btn-xs">Select
							Stop</button>
					</form>

					<div class="row">

						<p class="text-white-50">Choose your favourite bus line</p>
					



						<%
							//ArrayList<String> list = (ArrayList<String>)request.getAttribute("list");

							ArrayList<String> busAndTowardsList = new ArrayList<String>();
							ArrayList<String> timeDateList = new ArrayList<String>();
							//ArrayList<String> towardsList = new ArrayList<String>();
							
							
							busAndTowardsList = (ArrayList<String>)request.getAttribute("list1");
							// timeDateList = (ArrayList<String>)request.getAttribute("list2");
							
							
						%>

					</div>

					<div class="row">

						<select>
							<%
						if(busAndTowardsList!=null){
								for (int i = 0; i < busAndTowardsList.size(); i++) {
							%>

							<option>
								<%= busAndTowardsList.get(i) %>

							</option>

							<%
								}
						}
							%>

						</select>
						
						<button type="submit" class="btn btn-primary btn-xs">Choose
							line</button>
						</form>

					</div>

					

				</div>
			</div>
		</div>
	</section>

	<!-- Contact-->
	<section class="contact-section bg-black">
		<div class="container">
			<div class="row">
				<div class="col-md-4 mb-3 mb-md-0">
					<div class="card py-4 h-100">
						<div class="card-body text-center">
							<i class="fas fa-map-marked-alt text-primary mb-2"></i>
							<h4 class="text-uppercase m-0">Address</h4>
							<hr class="my-4" />
							<div class="small text-black-50"></div>
						</div>
					</div>
				</div>
				<div class="col-md-4 mb-3 mb-md-0">
					<div class="card py-4 h-100">
						<div class="card-body text-center">
							<i class="fas fa-envelope text-primary mb-2"></i>
							<h4 class="text-uppercase m-0">Email</h4>
							<hr class="my-4" />
							<div class="small text-black-50">
								<a href="#!">hello@yourdomain.com</a>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-4 mb-3 mb-md-0">
					<div class="card py-4 h-100">
						<div class="card-body text-center">
							<i class="fas fa-mobile-alt text-primary mb-2"></i>
							<h4 class="text-uppercase m-0">Phone</h4>
							<hr class="my-4" />
							<div class="small text-black-50">+46707506475</div>
						</div>
					</div>
				</div>
			</div>
			<div class="social d-flex justify-content-center">
				<a class="mx-2" href="#!"><i class="fab fa-twitter"></i></a> <a
					class="mx-2" href="#!"><i class="fab fa-facebook-f"></i></a> <a
					class="mx-2" href="#!"><i class="fab fa-github"></i></a>
			</div>
		</div>
	</section>
	<!-- Footer-->
	<footer class="footer bg-black small text-center text-white-50">
		<div class="container">Copyright Â© Your Website 2021</div>
	</footer>
	<!-- Bootstrap core JS-->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Third party plugin JS-->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>
	<!-- Core theme JS-->
	<script src="js/scripts.js"></script>
</body>
</html>
