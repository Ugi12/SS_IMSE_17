<!--
Layout f�r Registrierung-Seite 
@author Julian Thaler
-->
<!DOCTYPE html>
<html>
<head>
<title>Registrierung</title>

</head>
<body>
<jsp:include page="header.jsp"></jsp:include>


<!--banner-->
<div class="banner-top">
	<div class="container">
		<h1><a href="registrierung.jsp">Registrierung</a></h1>
	</div>
</div>
<!--login-->
<div class="container">
		<div class="Registrierung">
		
			<form method="post" action="<%=request.getContextPath()%>/register" accept-charset="iso-8859-1">
			<div class="col-md-6 login-do">
				<div class="login-mail">
					<input type="text" placeholder="Vorname" required="" name="firstname">
				</div>
				<div class="login-mail">
					<input type="text" placeholder="Nachname" required="" name="lastname">
				</div>
				<div class="login-mail">
					<input type="text" placeholder="Email" required="" name="email">
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
					<input type="submit" name="event" value="Registrieren">
				</label>
			</div>
			<div class="clearfix"> </div>
			</form>
		</div>

</div>
</body>
</html>