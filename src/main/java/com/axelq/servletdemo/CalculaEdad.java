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
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "calculaedad", value = "/calculaedad")
public class CalculaEdad extends HttpServlet {



    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        String strfecha = request.getParameter("fechanacimiento");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + "Servlet calcula Edad" + "</h1>");
        out.println("<p>" + "Edad calculada" + "</p>");
        if(request.getParameter("edad") != null) {
            out.println("Edad: " + request.getParameter("edad"));
        }
        out.println("</body></html>");


        if (strfecha == null) {
            response.getWriter().println("<h1>Error, la fecha de nacimiento es un valor obligatorio, favor de agregarlo como query parameter (en la URL)</h1>");
        }

        Date fechaNac = null;
        try{
            fechaNac = new SimpleDateFormat("dd-MM-yyyy").parse(strfecha);
        } catch (ParseException ex){
            Logger.getLogger(CalculaEdad.class.getName()).log(Level.SEVERE, null, ex);
        }

        if(fechaNac != null){
            Calendar fechaNacimiento = Calendar.getInstance();
            Calendar fechaActual = Calendar.getInstance();
            fechaNacimiento.setTime(fechaNac);

            int edad = fechaActual.get(Calendar.YEAR) - fechaNacimiento.get(Calendar.YEAR);

            request.setAttribute("edad", edad);
        }

        request.getRequestDispatcher("calculaedad.jsp").forward(request, response);
    }
}

