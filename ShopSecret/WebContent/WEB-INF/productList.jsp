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
	
</div>
</body>
</html>