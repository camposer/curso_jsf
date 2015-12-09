<%@page import="model.Producto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	
	<c:if test="${not empty sessionScope.errores}">
		<ul class="errores">
		<c:forEach var="e" items="${errores}">
			<li>${e}</li>
		</c:forEach>
		</ul>
	</c:if>
	<% session.removeAttribute("errores"); %>

	<form action="productos-guardar" method="post" novalidate>
		<input type="hidden" name="id" value="${producto.id}">
		<table id="tabla-form" class="tabla-centrada">
			<tr>
				<td>Nombre</td>
				<td><input type="text" 
					name="nombre"
					value="${sessionScope.producto.nombre}">
			</tr>
			<tr>
				<td>Precio</td>
				<td><input type="number" 
					name="precio"
					value="${producto.precio}">
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" value="Cancelar">
					<input type="submit" value="Guardar">
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
	<c:forEach var="p" items="${requestScope.productos}">
		<tr>
			<td>${p.id}</td>
			<td><c:out value="${p.nombre}"/></td>
			<td>${p.precio}</td>
			<td><a href="/ejercicio1/productos-mostrar?id=${p.id}">mostrar</a></td>
			<td><a 
				href="/ejercicio1/productos-eliminar?id=${p.id}"
				onclick="javascript:return confirm('Eliminar?')">eliminar</a></td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>