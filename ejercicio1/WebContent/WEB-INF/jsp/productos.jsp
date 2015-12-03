<%@page import="model.Producto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Productos</title>
	<link rel="stylesheet" type="text/css" href="css/comun.css">
	<link rel="stylesheet" type="text/css" href="css/productos.css">
</head>
<body>
	<h1>Productos</h1>
	
	<%
		List<String> errores = (List<String>)
			session.getAttribute("errores");
		if (errores != null && errores.size() > 0) {
	%>
		<ul class="errores">
		<%
			for (String e : errores) {
		%>
			<li><%= e %></li>
		<%
			}
		%>
		</ul>
	<%
			session.removeAttribute("errores");
		}
	%>
	
	<form action="productos-agregar" method="post" novalidate>
		<table id="tabla-form" class="tabla-centrada">
			<tr>
				<td>Nombre</td>
				<td><input type="text" name="nombre">
			</tr>
			<tr>
				<td>Precio</td>
				<td><input type="number" name="precio">
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" name="operacion" value="Modificar">
					<input type="submit" name="operacion" value="Agregar">
				</td>
			</tr>
		</table>
	</form>
	
	<br>
		
	<table id="tabla-productos" class="tabla-centrada tabla-datos">
		<tr>
			<th>Id</th>
			<th>Nombre</th>
			<th>Precio</th>
			<th>Mostrar</th>
			<th>Eliminar</th>
		</tr>	
	<% 
		List<Producto> productos = 
		(List<Producto>)request.getAttribute("productos");
		if (productos != null) for (Producto p : productos) {
	%>
	<!-- Esto es un comentario -->
		<tr>
			<td><%= p.getId() %></td>
			<td><%= p.getNombre() %></td>
			<td><%= p.getPrecio() %></td>
			<td><a href="#">mostrar</a></td>
			<td><a 
				href="/ejercicio1/productos-eliminar?id=<%= p.getId() %>"
				onclick="javascript:return confirm('Eliminar?')">eliminar</a></td>
		</tr>
	<%
		}
	%>	
	</table>
</body>
</html>