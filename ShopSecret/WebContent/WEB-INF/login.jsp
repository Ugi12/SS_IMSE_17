<!--
Layout f�r Login-Seite 
@author Julian Thaler
-->
<!DOCTYPE html>
<html>
<head>
<title>Login</title>

</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<!--banner-->
<div class="banner-top">
	<div class="container">
		<h1><a href="login.jsp">Login</a></h1>
	</div>
</div>
<!--login-->
<div class="container">
		<div class="Login">
		
			<form method="post" action="<%=request.getContextPath()%>/login">
			<div class="col-md-6 login-do">
				<div class="login-mail">
					<input type="text" placeholder="Email" required="" name="loginEmail">
				</div>
				<div class="login-mail">
					<input type="password" placeholder="Passwort" required="" name="loginPasswort">
				</div>
				<label class="hvr-skew-backward">
					<input type="submit" value="Einloggen">
				</label>
			</div>
			<div class="col-md-6 login-right">
				<a href="registrierung.jsp" class=" hvr-skew-backward">Registrieren</a>
			</div>
			
			<div class="clearfix"> </div>
			</form>
		</div>

</div>
</body>
</html>