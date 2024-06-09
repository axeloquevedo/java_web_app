<%--
  Created by IntelliJ IDEA.
  User: axelquevedo
  Date: 09/06/24
  Time: 2:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista de Personas</title>
</head>
<body>
<h1>Lista de Personas</h1>
<a href="PersonaServlet?action=new">Agregar Persona</a>
<table border="1">
    <tr>
        <th>Nombre</th>
        <th>Apellido</th>
        <th>Dirección</th>
        <th>Teléfono</th>
        <th>Sexo</th>
        <th>Acciones</th>
    </tr>
    <c:forEach var="persona" items="${listPersonas}">
        <tr>
            <td>${persona.nombre}</td>
            <td>${persona.apellido1}</td>
            <td>${persona.direccion}</td>
            <td>${persona.telefono}</td>
            <td>${persona.sexo}</td>
            <td>
                <a href="PersonaServlet?action=edit&nombre=${persona.nombre}">Editar</a>
                <a href="PersonaServlet?action=delete&nombre=${persona.nombre}" onclick="return confirm('¿Estás seguro?')">Eliminar</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

