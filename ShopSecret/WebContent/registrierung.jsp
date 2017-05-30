<!--
Layout für Registrierung-Seite
@author Julian Thaler
-->
<!DOCTYPE html>
<html>
<head>
<title>Registrierung Template</title>
<link href="CSS/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link href="CSS/style.css" rel="stylesheet" type="text/css" media="all" />	
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Shopin Responsive web template, Bootstrap Web Templates, Flat Web Templates, AndroId Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="CSS/style4.css" rel="stylesheet" type="text/css" media="all" />	
<script src="JS/jquery.min.js"></script>
<script src="JS/jstarbox.js"></script>
<link rel="stylesheet" href="CSS/jstarbox.css" type="text/css" media="screen" charset="utf-8" />
</head>
<body>
<!--header-->
<div class="header">
<div class="container">
		<div class="head">
			<div class=" logo">
				<a href="login.jsp"><img src="Images/logo1.png" alt=""></a>	
			</div>
		</div>
	</div>
	<div class="header-top">
		<div class="container">
		<div class="col-sm-5 col-md-offset-2  header-login">
					<ul >
						<li><a href="login.jsp">Login</a></li>
						<li><a href="registrierung.jsp">Registrieren</a></li>
						<li><a href="logout.jsp">Logout</a></li>
					</ul>
				</div>
				<div class="clearfix"> </div>
		</div>
		</div>
		
		<div class="container">
		
			<div class="head-top">
			
		 <div class="col-sm-8 col-md-offset-2 h_menu4">
				<nav class="navbar nav_bottom" role="navigation">
 
   <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-megadropdown-tabs">
        <ul class="nav navbar-nav nav_1">
            <li><a class="color" href="home.jsp">Home</a></li>
            <li><a class="color" href="männer.jsp">Männer</a></li>
            <li><a class="color" href="frauen.jsp">Frauen</a></li>
            <li><a class="color" href="kontakt.jsp">Kontakt</a></li>
            <li><a class="color" href="about.jsp">Über uns</a></li>
        </ul>
     </div>

			</nav>
		</div>
		</div>	
	</div>	
</div>
<!--banner-->
<div class="banner-top">
	<div class="container">
		<h1><a href="registrierung.jsp">Registrierung</a></h1>
	</div>
</div>
<!--login-->
<div class="container">
		<div class="Registrierung">
		
			<form>
			<div class="col-md-6 login-do">
				<div class="login-mail">
					<input type="text" placeholder="Vorname" required="" name="firstame">
				</div>
				<div class="login-mail">
					<input type="text" placeholder="Nachname" required="" name="lastname">
				</div>
				<div class="login-mail">
					<input type="text" placeholder="Email" required="" name="email">
				</div>
				<div class="login-mail">
					<input type="text" placeholder="Geburtstag" required="" name="birthday">
				</div>
				<div class="login-mail">
					<input type="text" placeholder="Adresse" required="" name="adress">
				</div>
				<div class="login-mail">
					<input type="text" placeholder="Stadt" required="" name="city">
				</div>
				<div class="login-mail">
					<input type="text" placeholder="Land" required="" name="country">
				</div>
				<div class="login-mail">
					<input type="password" placeholder="Passwort" required="" name="password">
				</div>
				<div class="login-mail">
					<input type="password" placeholder="Passwort wiederholen" required="" name="password2">
				</div>
				<label class="hvr-skew-backward">
					<input type="submit" value="Registrieren">
				</label>
			</div>
			<div class="clearfix"> </div>
			</form>
		</div>

</div>
</body>
</html>