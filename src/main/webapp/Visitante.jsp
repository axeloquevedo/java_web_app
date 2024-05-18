<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Visitante</title>
</head>
<body>
<%
    Cookie[] cookies = request.getCookies();
    String visitorName = null;

    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if ("visitorName".equals(cookie.getName())) {
                visitorName = cookie.getValue();
                break;
            }
        }
    }

    if (visitorName != null) {
        out.println("<h1>Bienvenido de nuevo, " + visitorName + "!</h1>");
    } else {
        response.sendRedirect("Inicio.jsp");
    }
%>
</body>
</html>
