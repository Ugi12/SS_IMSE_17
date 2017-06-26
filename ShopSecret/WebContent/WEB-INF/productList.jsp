<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="model.*"%>
<%@page import="java.util.*"%>
<%

@SuppressWarnings("unchecked")
List<Product> products = (List<Product>)request.getAttribute("productList");
List<Lineitem> items = (List<Lineitem>)request.getAttribute("lineItems");
Cart cart = (Cart)request.getAttribute("cart");
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
           		    <form class="navbar-form navbar-left" method="post" action="<%=request.getContextPath()%>/products">
				   		<input type="hidden" name="productId" value="<%=p.getId()%>" />
				  		<input type="hidden" name="typ" value="cart" />
				  		<input type="hidden" name="type" value="<%=p.getSex()%>" />
				  		<button type="submit" value="warenkorb" class="btn btn-default">Warenkorb</button>
				  	</form>
				</div>
				<%} %>
			  <%} %>
			</div>
		</div>
	
	<div id="cd-shadow-layer"></div>

      <!-- example mocked cart -->
			<div id="cd-cart">
				<h2>Warenkorb</h2>
				<ul class="cd-cart-items">
				
						<% for(Lineitem item : items){ %>
							<li>
								<form class="navbar-form navbar-left" method="post" action="<%=request.getContextPath()%>/products">
									<input type="hidden" name="typ" value="decrease" />
									<input type="hidden" name="itemId" value="<%=item.getId()%>" />
									<input type="hidden" name="type" value="<%=products.get(0).getSex()%>" />
									<input type="submit" value='-' class='qtyminus' field='quantity' />
									<% out.print(item.getQuantity()); %>x
								</form>
								<form class="navbar-form navbar-left" method="post" action="<%=request.getContextPath()%>/products">
									<input type="hidden" name="typ" value="increase" />
									<input type="hidden" name="itemId" value="<%=item.getId()%>" />
									<input type="hidden" name="type" value="<%=products.get(0).getSex()%>" />
									<input type="submit" value='+' class='qtyplus' field='quantity' />
								</form>
	
								<% out.print(item.getProduct().getName()); %>
	
								<div class="cd-price">$<% out.print(item.getProduct().getPrice()); %></div>
								
								<form class="navbar-form navbar-left" method="post" action="<%=request.getContextPath()%>/products">
									<input type="hidden" name="typ" value="remove" />
									<input type="hidden" name="itemId" value="<%=item.getId()%>" />
									<input type="hidden" name="type" value="<%=products.get(0).getSex()%>" />
									<a href="#" class="cd-item-remove cd-img-replace" onclick="$(this).closest('form').submit()">Remove</a>
								</form>
								
							</li>
						<%} %>
						
				</ul> <!-- cd-cart-items -->

				<div class="cd-cart-total">
					<% if (cart != null) { %>
						<p>Total <span>$<% out.print(cart.getTotal()); %></span></p>
					<% } else { %>
						<p>Total <span>$0</span></p>
					<% } %>
				</div> <!-- cd-cart-total -->

				<a href="#0" class="checkout-btn">Checkout</a>

				<p class="cd-go-to-cart"><a href="#0">Go to cart page</a></p>
			</div> <!-- cd-cart -->
	
</div>
</body>
</html>