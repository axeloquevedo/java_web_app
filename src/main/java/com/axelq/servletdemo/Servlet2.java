package com.axelq.servletdemo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.lang.System.out;

@WebServlet(name = "servlet2", value = "/servlet2")
public class Servlet2 extends HttpServlet{

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        request.getRequestDispatcher("/servlet3").include(request, response);

        int numeroAleatorio = (int) request.getAttribute("numeroAleatorio");

        response.getWriter().println("<h1>Servlet 2<h1>");
        response.getWriter().println("Numero generado en Servlet 3: ");
        response.getWriter().println(numeroAleatorio);

    }
}
