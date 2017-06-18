<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="model.*"%>
<%
	@SuppressWarnings("unchecked")
	Product product = (Product)request.getAttribute("product");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--  
			<div class="panel panel-default" style="width: 20%; float: left; margin: 10px;">
			  <div class="panel-body">
			    <% //out.print("Name: " + product.getName()); %></br>
			    <% //out.print("Preis: " + product.getPrice()); %></br>
			    <%// out.print("Kollektion: " + product.getSex()); %></br>
			  
			  </div>
			  <form class="navbar-form navbar-left" method="post" action="<%=request.getContextPath()%>/admin">
			    <input type="hidden" name="productId" value="<%=product.getId()%>" />
			  	<input type="hidden" name="event" value="delete" />
			  	<button type="submit" value="delete" class="btn btn-default">Löschen</button>
			  </form>
			  <form class="navbar-form navbar-left" method="post" action="<%=request.getContextPath()%>/admin">
			    <input type="hidden" name="productId_2" value="<%=product.getId()%>" />
			  	<input type="hidden" name="event" value="edit" />
			  	<button type="submit" value="edit" class="btn btn-default">Bearbeiten</button>
			  </form>
			</div>
-->
</body>
</html>