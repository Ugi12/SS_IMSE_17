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
@SuppressWarnings("unchecked")
List<Supplier> suppliers = (List<Supplier>)request.getAttribute("suppliers");
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
	      		 	<input type="text" name="name" class="form-control" required="" placeholder="Produktname" aria-describedby="basic-addon1">
	      		   	<input type="text" name="price" class="form-control" required="" placeholder="Preis" aria-describedby="basic-addon1">
				    <div class="radio">
				      <label><input type="radio" name="optradio" value="woman">Damenkollektion</label>
				    </div>
				    <div class="radio">
				      <label><input type="radio" name="optradio" value="man">Herrenkollektion</label>
				    </div>
				    <div class="form-group" >
						  <label for="sel1">Katalog</label>
						  <br clear="all">
						  <select name="catalog" class="form-control" id="sel1">
						  <option></option>
						  	<%
							  		for(Catalog c: catalogs){
							 %>
							  			<option <% if(catalogs != null){%> <% out.println("selected"); %>  <% }%>><% out.println(c.getName()); %></option>
							<%
									}
							%>
						  </select>
			  	</div>
			  	<div class="form-group" >
						  <label for="sel1">Lieferant</label>
						  <br clear="all">
						  <select name="supplierName" class="form-control" id="sel1">
						  <option></option>
						  	<%
							  		for(Supplier s: suppliers){
							 %>
							  			<option <% if(suppliers != null){%> <% out.println("selected"); %>  <% }%>><% out.println(s.getName()); %></option>
							<%
									}
							%>
						  </select>
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
			  		 <% out.print("Katalog: " + p.getCatalogName()); %></br>
			  		 <%for(Supplier s : suppliers){
			  			 if(s.getId() == p.getSupplierid()){%>
			  				<% out.print("Lieferant: " + s.getName()); %></br>
			  		<% 	 } 
			  		   }%>  
			  		 
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
            <form class="navbar-form navbar-left" method="post" action="<%=request.getContextPath()%>/admin">
				   		<input type="hidden" name="productId_2" value="<%=p.getId()%>" />
				  		<input type="hidden" name="event" value="warenkorp" />
				  		<button type="submit" value="warenkorp" class="btn btn-default">Warenkorb</button>
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
		      		<input type="text" name="name" class="form-control" placeholder="Katalogname" required=""  pattern=".{4,}" aria-describedby="basic-addon1">
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

      <div id="cd-shadow-layer"></div>

      <!-- example mocked cart -->
			<div id="cd-cart">
				<h2>Warenkorb</h2>
				<ul class="cd-cart-items">
						<li>
							<input type='button' value='-' class='qtyminus' field='quantity' />
							<span class="cd-qty">1x</span>
							<input type='button' value='+' class='qtyplus' field='quantity' />

							Product Name

							<div class="cd-price">$9.99</div>
							<a href="#0" class="cd-item-remove cd-img-replace">Remove</a>
						</li>

						<li>
							<span class="cd-qty">2x</span> Product Name
							<div class="cd-price">$19.98</div>
							<a href="#0" class="cd-item-remove cd-img-replace">Remove</a>
						</li>

						<li>
							<span class="cd-qty">1x</span> Product Name
							<div class="cd-price">$9.99</div>
							<a href="#0" class="cd-item-remove cd-img-replace">Remove</a>
						</li>
				</ul> <!-- cd-cart-items -->

				<div class="cd-cart-total">
					<p>Total <span>$39.96</span></p>
				</div> <!-- cd-cart-total -->

				<a href="#0" class="checkout-btn">Checkout</a>

				<p class="cd-go-to-cart"><a href="#0">Go to cart page</a></p>
			</div> <!-- cd-cart -->


		</div>
		
		
		
		<div class="panel panel-default" style="width: 100%; float: left; padding: 10px;">
			<div class="input-group">
				<h4>Lieferant erstellen</h4>
	      		<form class="navbar-form navbar-left" method="post" action="<%=request.getContextPath()%>/admin">
		      		<input type="text" name="name" class="form-control" placeholder="Lieferanten Name" required="" pattern=".{4,}" aria-describedby="basic-addon1">
				  	<input type="hidden" name="event" value="createSupplier" />
				  	<button type="submit" value="create" class="btn btn-default">Erstellen</button>
			  	</form>
			</div>

			<div class="input-group">
				<h4>Lieferant löschen</h4>
      			<form class="navbar-form navbar-left" method="post" action="<%=request.getContextPath()%>/admin">

		  				<div class="form-group" >
						  <label for="sel1">Lieferant</label>
						  <br clear="all">
						  <select name="supplierName" class="form-control" id="sel1">
						  <option></option>
						  	<%
							  		for(Supplier s: suppliers){
							 %>
							  			<option <% if(suppliers != null){%> <% out.println("selected"); %>  <% }%>><% out.println(s.getName()); %></option>
										
							<%
									}
			
							%>
						  </select>


			  	 	<input type="hidden" name="event" value="deleteSupplier" />
			  	 	
			  		<button type="submit" value="delete" class="btn btn-default">Löschen</button>
			  	</div>
		 		</form>

			</div>
			
			</div>

	</body>
</html>
