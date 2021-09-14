<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
<div>
<h1>Exito</h1>
<h2>Nombre: <c:out value="${nombre}"></c:out></h2>
<h2>Apellido: <c:out value="${apellido}"></c:out></h2>
<h2>Limite: <c:out value="${limite}"></c:out></h2>
<h2>Codigo postal: <c:out value="${codigoPostal}"></c:out></h2>
</div>
</body>
</html>