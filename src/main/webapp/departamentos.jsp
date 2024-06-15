<%--
  Created by IntelliJ IDEA.
  User: axelquevedo
  Date: 14/06/24
  Time: 10:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Departamentos</title>
</head>
<body>
<h1>Departamentos</h1>
<form action="DepartamentoServlet" method="post">
    <input type="hidden" name="action" value="insert">
    Nombre: <input type="text" name="nombre">
    <input type="submit" value="Agregar">
</form>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Nombre</th>
        <th>Acciones</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="departamento" items="${listaDepartamentos}">
        <tr>
            <td>${departamento.id}</td>
            <td>${departamento.nombre}</td>
            <td>
                <form action="DepartamentoServlet" method="post" style="display:inline;">
                    <input type="hidden" name="action" value="update">
                    <input type="hidden" name="id" value="${departamento.id}">
                    Nombre: <input type="text" name="nombre" value="${departamento.nombre}">
                    <input type="submit" value="Actualizar">
                </form>
                <form action="DepartamentoServlet" method="get" style="display:inline;">
                    <input type="hidden" name="action" value="delete">
                    <input type="hidden" name="id" value="${departamento.id}">
                    <input type="submit" value="Eliminar">
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>

