<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link href="CSS/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link href="CSS/style.css" rel="stylesheet" type="text/css" media="all" />
<link rel="stylesheet" href="CSS/resetCart.css"> <!-- CSS reset -->
<link rel="stylesheet" href="CSS/styleCart.css"> <!-- Gem style -->
<script src="JS/modernizr.js"></script> <!-- Modernizr -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Shopin Responsive web template, Bootstrap Web Templates, Flat Web Templates, AndroId Compatible web template,
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="CSS/style4.css" rel="stylesheet" type="text/css" media="all" />
<script src="JS/jquery.min.js"></script>
<script src="JS/jstarbox.js"></script>
<link rel="stylesheet" href="CSS/jstarbox.css" type="text/css" media="screen" charset="utf-8" />
<%@page import="model.*"%>
</head>
<%

 Object credentials = request.getSession().getAttribute("credentials");

%>
<body>
<div class="header">
<div class="container">
		<div class="head">
			<div class=" logo">
				<a href="<%=request.getContextPath()%>/home"><img src="Images/logo1.png" alt=""></a>
			</div>
		</div>
	</div>
	<div class="header-top">
		<div class="container">
		<div class="col-sm-5 col-md-offset-2  header-login">
					<ul >
						<% if (credentials == null) { %>
							<li><a href="<%=request.getContextPath()%>/login">Login</a></li>
							<li><a href="<%=request.getContextPath()%>/register">Registrieren</a></li>
						<% } else { %>
							<li><a href="#0">Welcome <% out.print(credentials); %></a></li>
							<li><a href="<%=request.getContextPath()%>/logout">Logout</a></li>
						<% } %>
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
            <li><a class="color" href="<%=request.getContextPath()%>/home">Home</a></li>
            <li><a class="color" href="<%=request.getContextPath()%>/products?type=man">Männer</a></li>
            <li><a class="color" href="<%=request.getContextPath()%>/products?type=woman">Frauen</a></li>
            <li><a class="color" href="<%=request.getContextPath()%>/contact">Kontakt</a></li>
            <li><a class="color" href="<%=request.getContextPath()%>/about">Über uns</a></li>
            <% if (credentials != null) { %>
           		<li id="cd-cart-trigger"><a class="cd-img-replace" href="#0">Cart</a></li>
            <% } %>
        </ul>
     </div>

			</nav>
		</div>
		</div>
	</div>
</div>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="JS/main.js"></script> <!-- Gem jQuery -->

</body>
</html>
