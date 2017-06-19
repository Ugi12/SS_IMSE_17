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
<title>Produkt ändern</title>
</head>
<body>
 		<%if(product != null){ %>
			<form class="navbar-form navbar-left" method="post" action="<%=request.getContextPath()%>/editcontroller">
		    		<input type="text" name="name" 	value="<%=product.getName()%>" 	class="form-control" placeholder="Produktname" aria-describedby="basic-addon1">	
		    		<input type="text" name="price" value="<%=product.getPrice()%>" class="form-control" placeholder="Preis" aria-describedby="basic-addon1">	
					<input type="text" name="sex" 	value="<%=product.getSex()%>" 	class="form-control" placeholder="Kollektion" aria-describedby="basic-addon1">
			   		<input type="hidden" name="id" value="<%=product.getId()%>" />
			   		<input type="hidden" name="supplierid" value="<%=product.getSupplierid()%>" />
			   		<input type="hidden" name="event" value="updateProduct" />
				<button type="submit" value="create" class="btn btn-default">Produkt ändern</button>
			</form>
		<%} %>
</body>
</html>