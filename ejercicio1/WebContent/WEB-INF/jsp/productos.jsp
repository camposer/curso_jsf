<%@page import="model.Producto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Productos</title>
	<style>
		h1 {
			text-align: center;
		}
		
		table.tabla-centrada {
			margin-left: auto;
			margin-right: auto;
		}		
		
		table.tabla-datos th {
			background-color: gray;
		}

		table.tabla-datos tr:nth-child(odd) td {
			background-color: lightgray;
		}

		table.tabla-datos tr:nth-child(even) td {
			background-color: darkgray;
		}
		
		#tabla-productos {
			width: 80%;
		}

		#tabla-productos td:nth-child(1),
		#tabla-productos td:nth-child(3) {
			text-align: center;
		}

		#tabla-form tr:last-child td {
			text-align: center;
		}
		
		#tabla-form input[type=text],
		#tabla-form input[type=number] {
			width: 200px;
		}
		
		.errores {
			text-align: center;
			background-color: red;
		}
	</style>
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
		</tr>
	<%
		}
	%>	
	</table>
</body>
</html>