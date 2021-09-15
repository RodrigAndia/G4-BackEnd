<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Persona</title>
</head>
<body>
	<div>
		<form:form action="/persona/modificar" method="post" modelAttribute="persona">
	        <input type="hidden" name="_method" value="put">
            <form:hidden path="id"/>
            
			<form:label path="rut">rut:</form:label>
			<form:input type="text" path="rut"/><br>
			
			<form:label path="dv">digito verifidor:</form:label>
			<form:input type="text" path="dv"/><br>
			
			<form:label path="nombre">nombre:</form:label>
			<form:input type="text" path="nombre"/><br>
			
			<form:label path="apellido">apellido:</form:label>
			<form:input type="text" path="apellido"/><br>
			
			<form:label path="email">email:</form:label>
			<form:input type="text" path="email"/><br>
			
			<input type="submit" value="Modificar"></input><br>
		</form:form>
		
	</div>
</body>
</html>