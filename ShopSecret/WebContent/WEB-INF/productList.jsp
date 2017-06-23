<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="model.*"%>
<%@page import="java.util.*"%>
<%

@SuppressWarnings("unchecked")
List<Product> products = (List<Product>)request.getAttribute("productList");
%>

<!--
Layout für Product-Seite
@author Julian Thaler
@author yemrekanitoglu
-->
<html>
<head>
<title>Produkten</title>

</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<!--banner-->
<div class="banner-top">
	<div class="container">
		<h1><a href="home.jsp">${productType}</a></h1>
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
				   		<input type="hidden" name="productId_2" value="<%=p.getId()%>" />
				  		<input type="hidden" name="event" value="warenkorp" />
				  		<button type="submit" value="warenkorp" class="btn btn-default">Warenkorp</button>
				  	</form>
				</div>
				<%} %>
			  <%} %>
			</div>
		</div>
	
	<div id="cd-shadow-layer"></div>

      <!-- example mocked cart -->
			<div id="cd-cart">
				<h2>Warenkorp</h2>
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
</body>
</html>