<%--
  Created by IntelliJ IDEA.
  User: axelquevedo
  Date: 14/06/24
  Time: 10:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Profesores</title>
</head>
<body>
<h1>Profesores</h1>
<form action="ProfesorServlet" method="post">
  <input type="hidden" name="action" value="insert">
  ID Departamento: <input type="text" name="id_departamento">
  ID Persona: <input type="text" name="id_persona">
  <input type="submit" value="Agregar">
</form>
<table border="1">
  <thead>
  <tr>
    <th>ID</th>
    <th>ID Departamento</th>
    <th>ID Persona</th>
    <th>Acciones</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="profesor" items="${listaProfesores}">
    <tr>
      <td>${profesor.id}</td>
      <td>${profesor.idDepartamento}</td>
      <td>${profesor.idPersona}</td>
      <td>
        <form action="ProfesorServlet" method="post" style="display:inline;">
          <input type="hidden" name="action" value="update">
          <input type="hidden" name="id" value="${profesor.id}">
          ID Departamento: <input type="text" name="id_departamento" value="${profesor.idDepartamento}">
          ID Persona: <input type="text" name="id_persona" value="${profesor.idPersona}">
          <input type="submit" value="Actualizar">
        </form>
        <form action="ProfesorServlet" method="get" style="display:inline;">
          <input type="hidden" name="action" value="delete">
          <input type="hidden" name="id" value="${profesor.id}">
          <input type="submit" value="Eliminar">
        </form>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>

