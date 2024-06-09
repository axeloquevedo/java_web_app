<%--
  Created by IntelliJ IDEA.
  User: axelquevedo
  Date: 09/06/24
  Time: 2:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Formulario de Persona</title>
</head>
<body>
<h1>${persona == null ? 'Agregar' : 'Editar'} Persona</h1>
<form action="PersonaServlet?action=${persona == null ? 'insert' : 'update'}" method="post">
    <%--@declare id="apellido1"--%><%--@declare id="nombre"--%><%--@declare id="direccion"--%><%--@declare id="telefono"--%><%--@declare id="sexo"--%><input type="hidden" name="nombre" value="${persona.nombre}"/>
    <label for="nombre">Nombre:</label>
    <input type="text" name="nombre" value="${persona.nombre}" ${persona != null ? 'readonly' : ''}/><br>
    <label for="apellido1">Apellido:</label>
    <input type="text" name="apellido1" value="${persona.apellido1}"/><br>
    <label for="direccion">Dirección:</label>
    <input type="text" name="direccion" value="${persona.direccion}"/><br>
    <label for="telefono">Teléfono:</label>
    <input type="text" name="telefono" value="${persona.telefono}"/><br>
    <label for="sexo">Sexo:</label>
    <input type="text" name="sexo" value="${persona.sexo}"/><br>
    <input type="submit" value="${persona == null ? 'Agregar' : 'Actualizar'}"/>
</form>
</body>
</html>

