<!--
Layout für Login-Seite 
@author Julian Thaler
-->
<!DOCTYPE html>
<html>
<head>
<title>Login</title>

</head>
<body>
<jsp:include page="WEB-INF/header.jsp"></jsp:include>

<!--banner-->
<div class="banner-top">
	<div class="container">
		<h1><a href="login.jsp">Login</a></h1>
	</div>
</div>
<!--login-->
<div class="container">
		<div class="Login">
		
			<form>
			<div class="col-md-6 login-do">
				<div class="login-mail">
					<input type="text" placeholder="Email" required="" name="LoginEmail">
				</div>
				<div class="login-mail">
					<input type="password" placeholder="Passwort" required="" name="LoginPasswort">
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