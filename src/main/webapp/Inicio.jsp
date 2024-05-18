<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Inicio</title>
</head>
<body>
<%
    Cookie[] cookies = request.getCookies();
    boolean found = false;

    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if ("visitorName".equals(cookie.getName())) {
                found = true;
                break;
            }
        }
    }

    if (found) {
        response.sendRedirect("Visitante.jsp");
    }
%>

<h1>Bienvenido</h1>
<p>Veo que es tu primera vez en el sitio</p>
<form action="Inicio" method="post">
    <label for="nombre">¿Cómo te llamas? </label>
    <input type="text" id="nombre" name="nombre" required>
    <input type="submit" value="Enviar">
</form>
</body>
</html>
