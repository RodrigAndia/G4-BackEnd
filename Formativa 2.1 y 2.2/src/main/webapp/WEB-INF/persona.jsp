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
		<form:form action="/persona/crear" method="post" modelAttribute="persona">
			<form:label path="rut">rut:</form:label>
			<form:input type="text" path="rut"/><br>
			
			<form:label path="dv">dv:</form:label>
			<form:input type="text" path="dv"/><br>
			
			<form:label path="nombre">nombre:</form:label>
			<form:input type="text" path="nombre"/><br>
			
			<form:label path="apellido">apellido:</form:label>
			<form:input type="text" path="apellido"/><br>
			
			<form:label path="email">email:</form:label>
			<form:input type="text" path="email"/><br>
			
			<input type="submit" value="Crear Persona"></input><br>
		</form:form>
		<br>
		<h1>Lista Personas</h1>
		<table>
			<thead>
				<tr>
					<th>#</th>
					<th>Rut</th>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>Email</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="persona" items="${lista_personas}" >
					<tr>
						<td><c:out value="${persona.id}" /> </td>
						<td><c:out value="${persona.rut}" /> - <c:out value="${persona.dv}" /> </td>
						<td><c:out value="${persona.nombre}" /> </td>
						<td><c:out value="${persona.apellido}" /> </td>
						<td><c:out value="${persona.email}" /> </td>
						<td>
							<a href="/persona/actualizar/${persona.id}">Editar</a>
							
							<form action="/persona/eliminar" method="POST">
							<input type="hidden" name="id" value="<c:out value="${persona.id}" />" >
							<input type="submit" value="Eliminar">
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>