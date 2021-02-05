


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Index</title>
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





<% Cookie[] cookies = request.getCookies();

	
for (Cookie ck: cookies){
	
	try{ck.setMaxAge(0);
	 response.addCookie(ck);
	 }catch(Exception e)
	{System.out.println("Refresh page");}
	
	 System.out.println(ck);
}

%>
      
	<!-- Navigation-->
	<nav class="navbar navbar-expand-lg navbar-light fixed-top"
		id="mainNav">
		<div class="container">
			<a class="navbar-brand js-scroll-trigger" href="#page-top">Start</a>
			<button class="navbar-toggler navbar-toggler-right" type="button"
				data-toggle="collapse" data-target="#navbarResponsive"
				
				aria-controls="navbarResponsive" aria-expanded="false"
				aria-label="Toggle navigation">
				Menu <i class="fas fa-bars"></i>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="#about">Login</a></li>
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="#signup">Sign up</a></li>
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="#contact">Contact</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<!-- Masthead-->
	
	
	<header
    class="p-5 text-center bg-image"
    style="
      background-image: url('/assets/img/skanetrafiken.jpeg');
      height: 400px;
    "
  >
  
  
<!-- 	<header class="masthead">  -->
		<div class="container d-flex h-100 align-items-center">
			<div class="mx-auto text-center">
				<h1 class="mx-auto my-0 text-uppercase">TRAVELERS</h1>
				<h2 class="text-white-50 mx-auto mt-2 mb-5">WELCOME!</h2>
				<a class="btn btn-primary js-scroll-trigger" href="#about">LOGIN</a>
			</div>
		</div>
	</header>
	<!-- login-->
	<section class="about-section text-center" id="about">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 mx-auto">
					<h2 class="text-white mb-4">login</h2>
					<p class="text-white-50">
					
						<!--Login form-->
					<form action = "<%= request.getContextPath()%>/login" method = "POST">
						<div class="mb-3">

							<input type="email" class="form-control" name="email"
								id="exampleInputEmail1" aria-describedby="emailHelp"
								placeholder="Email address">
						</div>
						<div class="mb-3">

							<input type="password" class="form-control"
								id="exampleInputPassword1" placeholder="Password" name = "password">
						</div>

						<button type="submit" class="btn btn-primary">Login</button>
					</form>
					

				</div>
			</div>
		
		</div>
	</section>
	
	<!-- Sign up-->
	<section class="projects-section bg-light" id="projects">
		<div class="container">
			<!-- Featured Project Row-->
			<div class="row align-items-center no-gutters mb-4 mb-lg-5" >
				<div class="col-xl-8 col-lg-7"  id = "signup">
					<img class="img-fluid mb-3 mb-lg-0"
						src="assets/img/bg-masthead.jpg" alt="" />
				</div>
				<div class="col-xl-4 col-lg-5" >
					<div class="featured-text text-center text-lg-left">


						<div class="container" >
							<h4 >Sign up!</h4>


							<!--Sign up form-->

							<form action = "<%=request.getContextPath()%>/signupcontoller" method = "post">



								<div class="mb-3" >
									<div class="row">
										<!--  <div class="row g-3">-->
										<div class="col-6">
											<input type="text" class="form-control"
												placeholder="First name" aria-label="First name" name = "signUpfName">
										</div>
										<div class="col-6">
											<input type="text" class="form-control"
												placeholder="Last name" aria-label="Last name" name = "signUplName">
										</div>
									</div>
								</div>

								<div class="mb-3">

									<input type="email" class="form-control" name="signUpEmail"
										id="inputEmail" aria-describedby="emailHelp"
										placeholder="Email address">
								</div>
								<div class="mb-3">

									<input type="password" class="form-control"
										id="inputPassword" placeholder="Password" name = "signUpPassword">
								</div>
								
								<div class = "col" align = "right">
								<button type="submit" class="btn btn-primary" >Submit</button>
								</div>
							</form>

						</div>




					</div>
				</div>
			</div>

		</div>
	</section>
	
	
	
	<!-- Contact-->
	<section class="contact-section bg-black" id = "contact">
		<div class="container">
			<div class="row">
				<div class="col-md-4 mb-3 mb-md-0">
					<div class="card py-4 h-100">
						<div class="card-body text-center">
							<i class="fas fa-map-marked-alt text-primary mb-2"></i>
							<h4 class="text-uppercase m-0">Address</h4>
							<hr class="my-4" />
							<div class="small text-black-50">Malmö,
								Sweden</div>
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
								<a href="#!">Daniel.levin76@outlook.com</a>
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
