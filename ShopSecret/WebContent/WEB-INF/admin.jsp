<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="model.*"%>
<%@page import="java.util.*"%>
<%

@SuppressWarnings("unchecked")
List<Product> products = (List<Product>)request.getAttribute("products");
@SuppressWarnings("unchecked")
List<Catalog> catalogs = (List<Catalog>)request.getAttribute("catalogs");

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
			 	 <%if(request.getAttribute("error") != null){%>
	    	<script type="text/javascript">
	    		alert("Falsche Eingabe");
	    	</script>
	    <% } %>
		    </div>
		</div>
		
		<div class="panel panel-default" style="width: 100%; float: left; padding: 10px;">
			<div class="input-group">
				<%if(products != null){ %>
				<% for(Product p : products){ %>
				<div class="panel panel-default" style="width: 30%; float: left; margin: 10px;">
			 		 <div class="panel-body">
			   		 <% out.print("Name: " + p.getName()); %></br>
			  		 <% out.print("Preis: " + p.getPrice()); %></br>
			  		 <% out.print("Kollektion: " + p.getSex()); %></br>
			  		</div>
				  	<form class="navbar-form navbar-left" method="post" action="<%=request.getContextPath()%>/admin">
				    	<input type="hidden" name="productId" value="<%=p.getId()%>" />
				  		<input type="hidden" name="event" value="delete" />
				  		<button type="submit" value="delete" class="btn btn-default">Löschen</button>
				  	</form>
				  	<form class="navbar-form navbar-left" method="post" action="<%=request.getContextPath()%>/admin">
				   		<input type="hidden" name="productId_2" value="<%=p.getId()%>" />
				  		<input type="hidden" name="event" value="edit" />
				  		<button type="submit" value="edit" class="btn btn-default">Bearbeiten</button>
				  	</form>
				</div>
				<%} %>
			  <%} %>
			</div>
		</div>
		
		<div class="panel panel-default" style="width: 100%; float: left; padding: 10px;">
			<div class="input-group">
				<h4>Erstelle neuer Katalog</h4>
	      		<form class="navbar-form navbar-left" method="post" action="<%=request.getContextPath()%>/admin">
		      		<input type="text" name="name" class="form-control" placeholder="Katalogname" pattern=".{4,}" aria-describedby="basic-addon1">	
				  	<input type="hidden" name="event" value="createCatalog" />
				  	<button type="submit" value="create" class="btn btn-default">Erstellen</button>
			  	</form>
			</div>
		    
			<div class="input-group">
				<h4>Katalog löschen</h4>
      			<form class="navbar-form navbar-left" method="post" action="<%=request.getContextPath()%>/admin">
		  			
		  				<div class="form-group" >
						  <label for="sel1">Katalog</label>
						  <br clear="all">
						  <select name="catalogName" class="form-control" id="sel1">
						  <option></option>
						  	<% 
							  		for(Catalog c: catalogs){
							 %>		
							  			<option <% if(catalogs != null){%> <% out.println("selected"); %>  <% }%>><% out.println(c.getName()); %></option>	
							<%   
									}
							%>
						  </select>
						
	      		 	
			  	 	<input type="hidden" name="event" value="deleteCatalog" />
			  		<button type="submit" value="delete" class="btn btn-default">Löschen</button>
			  	</div>
		 		</form>
		 		
			</div>
			
		</div>
		
	</body>
</html>