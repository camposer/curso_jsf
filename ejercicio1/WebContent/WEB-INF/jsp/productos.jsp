<%@page import="model.Producto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Productos</title>
</head>
<body>
	<h1>Listado de Productos</h1>
	<table>
		<tr>
			<th>Id</th>
			<th>Nombre</th>
			<th>Precio</th>
		</tr>	
	<% 
		List<Producto> productos = (List<Producto>)request.getAttribute("productos");
		if (productos != null) for (Producto p : productos) {
	%>
		<tr>
			<td><%= p.getId() %></td>
			<td><%= p.getNombre() %></td>
			<td><%= p.getPrecio() %></td>
		</tr>
	<%
		}
	%>	
	</table>
	
</body>
</html>