<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="model.*"%>
<%@page import="java.util.*"%>
<%
	
	Product product = (Product)request.getAttribute("product");
	@SuppressWarnings("unchecked")
	List<Catalog> catalogs = (List<Catalog>)request.getAttribute("catalogs");
	@SuppressWarnings("unchecked")
	List<Supplier> suppliers = (List<Supplier>)request.getAttribute("suppliers");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Produkt ändern</title>
</head>
<body>
 		<%if(product != null){ %>
	<div class="panel panel-default" style="width: 100%; float: left; padding: 10px;">
			<div class="input-group">
				<h4>Produkt ändern</h4>
	      		<form class="navbar-form navbar-left" method="post" action="<%=request.getContextPath()%>/editcontroller">
	      		 	<input type="text" name="name" class="form-control" required="" value="<%=product.getName()%>" placeholder="Produktname" aria-describedby="basic-addon1">
	      		   	<input type="text" name="price" class="form-control" required="" value="<%=product.getPrice()%>" placeholder="Preis" aria-describedby="basic-addon1">
				  
				    <div class="form-group" >
						  <label for="sel1">Katalog</label>
						  <br clear="all">
						  <select name="catalog" class="form-control" id="sel1">
						 
						  	<%
							  		for(Catalog c: catalogs){
							 %>
							  			<%if(c.getName().equals(product.getCatalogName())){ %>
							  				<option selected='selected'><% out.println(c.getName()); %></option>
							<%  		}else if(!c.getName().equals(product.getCatalogName())){
									%>		<option><% out.println(c.getName()); %>
					  						</option>
									<%	}
							
									}
							%>
						  </select>
			  	</div>
			  	<div class="form-group" >
						  <label for="sel1">Lieferant</label>
						  <br clear="all">
						  <select name="supplierName" class="form-control" id="sel1">
						  
						  	<%
							  		for(Supplier s: suppliers){
									 if(s.getId() == product.getSupplierid()){ %>
									  				<option selected='selected'><% out.println(s.getName()); %></option>
									<%}else if(s.getId() != product.getSupplierid()){
									%>	<option><% out.println(s.getName()); %>
							  			</option>
									<%}
									}
							%>
						  </select>
			  	</div>
			  	
				  	<input type="hidden" name="id" value="<%=product.getId()%>" />
				   	<input type="hidden" name="sex" value="<%=product.getSex()%>" />
			   		<input type="hidden" name="event" value="updateProduct" />
				<button type="submit" value="create" class="btn btn-default">Produkt ändern</button>
				
			 	 </form>
			 	 </div>

	    <% } %>
		    
		</div>
		
</body>
</html>