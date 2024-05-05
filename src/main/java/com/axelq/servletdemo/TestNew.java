package com.axelq.servletdemo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "testnew", value = "/testnew")
public class TestNew extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        String mensaje = request.getParameter("mensaje");

        if (mensaje == null) {
            response.getWriter().println("<h1>Error, el mensaje es un valor obligatorio</h1>");
        } else {
            response.getWriter().println("<h1>" + mensaje + "</h1>");
        }


    }

}
