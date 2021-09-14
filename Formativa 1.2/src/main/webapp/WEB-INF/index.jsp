<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>  
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Grupo 4</title>
</head>
<body>
	<h1>Registro de usuarios</h1>
	<form action="/formulario" method="post">
	<br>
	<label for="nombre">Nombre:</label>
	<input type="text" name="nombre">
	<br><br>
	<label for="apellido">Apellido:</label>
	<input type="text" name="apellido">
	<br><br>
	<label for="limite">Limite:</label>
	<input type="number" name="limite">
	<br><br>
	<label for="codigoPostal">Codigo Postal:</label>
	<input type="text" name="codigoPostal">
	<br><br>
	
	<input type="submit" value="Enviar">
	
	</form>
	
</body>
</html>