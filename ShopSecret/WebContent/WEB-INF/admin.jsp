<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="model.*"%>
<%@page import="java.util.*"%>
<%

%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title> ShopSecret administration </title>
	</head>
	<body>
		<jsp:include page="header.jsp"></jsp:include>
		<div class="panel panel-default" style="width: 100%; float: left; padding: 10px;">
			<div class="input-group">
			<h4>Erstelle neues Produkt</h4>
	      		<form class="navbar-form navbar-left" method="post" action="<%=request.getContextPath()%>/admin">
	      		  <input type="text" name="name" class="form-control" placeholder="Produktname" aria-describedby="basic-addon1">	
	      		   <input type="text" name="price" class="form-control" placeholder="Preis" aria-describedby="basic-addon1">	
				    <div class="radio">
				      <label><input type="radio" name="optradio" value="woman">Damenkollektion</label>
				    </div>
				    <div class="radio">
				      <label><input type="radio" name="optradio" value="man">Herrenkollektion</label>
				    </div>
				    <input type="hidden" name="event" value="createProduct" />
					<button type="submit" value="create" class="btn btn-default">Erstellen</button>
			  </form>
			</div>
		    </form>
		    <div class="input-group">
			<h4>Produkt ändern</h4>
	      		<form class="navbar-form navbar-left" method="post" action="<%=request.getContextPath()%>/admin">
	      		  <input type="text" name="name" class="form-control" placeholder="Produktname" aria-describedby="basic-addon1">	
			  	  <input type="hidden" name="event" value="updateProduct" />
			  	<button type="submit" value=update class="btn btn-default">Ändern</button>
			  </form>
			</div>
			<div class="input-group">
			<h4>Produkt löschen</h4>
	      		<form class="navbar-form navbar-left" method="post" action="<%=request.getContextPath()%>/admin">
	      		  <input type="text" name="name" class="form-control" placeholder="Produktname" aria-describedby="basic-addon1">	
			  	  <input type="hidden" name="event" value="deleteProduct" />
			  	<button type="submit" value="delete" class="btn btn-default">Löschen</button>
			  </form>
			</div>
			
			<div class="input-group">
			<h4>Erstelle neuer Katalog</h4>
	      		<form class="navbar-form navbar-left" method="post" action="<%=request.getContextPath()%>/admin">
	      		  <input type="text" name="name" class="form-control" placeholder="Katalogname" aria-describedby="basic-addon1">	
			  	  <input type="hidden" name="event" value="createCatalog" />
			  	<button type="submit" value="create" class="btn btn-default">Erstellen</button>
			  </form>
			</div>
		    </form>
		    <div class="input-group">
			<h4>Katalog ändern</h4>
	      		<form class="navbar-form navbar-left" method="post" action="<%=request.getContextPath()%>/admin">
	      		  <input type="text" name="name" class="form-control" placeholder="Katalogname" aria-describedby="basic-addon1">	
			  	  <input type="hidden" name="event" value="updateCatalog" />
			  	<button type="submit" value=update class="btn btn-default">Ändern</button>
			  </form>
			</div>
			<div class="input-group">
			<h4>Katalog löschen</h4>
	      		<form class="navbar-form navbar-left" method="post" action="<%=request.getContextPath()%>/admin">
	      		  <input type="text" name="name" class="form-control" placeholder="Katalogname" aria-describedby="basic-addon1">	
			  	  <input type="hidden" name="event" value="deleteCatalog" />
			  	<button type="submit" value="delete" class="btn btn-default">Löschen</button>
			  </form>
			</div>
			
		</div>
	</body>
</html>