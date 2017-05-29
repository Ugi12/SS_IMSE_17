<%@page import="java.text.DecimalFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.*"%>
<%@page import="java.util.*"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%//List<Customer> allCustomer = (List<Customer>) request.getAttribute("allCustomer"); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>hello world</title>
</head>
<body>
<%
Customer customer = (Customer)request.getAttribute("customer");
//List<Customer> list = (List<Customer>)request.getAttribute("customers");
	out.println(customer.getId());
	out.println("<br/>");
	out.println(customer.getAddress());
	out.println("<br/>");
	out.println(customer.getEmail());
//	for(Customer l:list){
//		out.println(l.getEmail());
//	}

%>
</body>
</html>