package com.axelq.servletdemo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "Inicio", value = "/Inicio")

public class Inicio extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        String nombre = request.getParameter("nombre");

        if (nombre != null && !nombre.isEmpty()) {
            Cookie visitorCookie = new Cookie("visitorName", nombre);
            visitorCookie.setMaxAge(60 * 60 * 24 * 365); // 1 semana
            response.addCookie(visitorCookie);
            response.sendRedirect("Visitante.jsp");
        } else {
            response.sendRedirect("Inicio.jsp");
        }

    }
}
