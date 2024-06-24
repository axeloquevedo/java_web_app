<%--
  Created by IntelliJ IDEA.
  User: axelquevedo
  Date: 22/06/24
  Time: 11:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Lista de Grados</title>
</head>
<body>
<h1>Lista de Grados</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Nombre</th>
    </tr>
    <c:forEach var="grado" items="${listGrados}">
        <tr>
            <td>${grado.id}</td>
            <td>${grado.nombre}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>


