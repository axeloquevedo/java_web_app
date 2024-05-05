package com.axelq.servletdemo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(name = "calculaedad", value = "/calculaedad")
public class CalculaEdad extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        String fecha = request.getParameter("fechanacimiento");

        if (fecha == null) {
            response.getWriter().println("<h1>Error, la fecha de nacimiento es un valor obligatorio, favor de agregarlo como query parameter (en la URL)</h1>");
        }


    }


}
