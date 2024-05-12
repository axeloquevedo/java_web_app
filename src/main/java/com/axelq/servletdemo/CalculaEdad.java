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
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "calculaedad", value = "/calculaedad")
public class CalculaEdad extends HttpServlet {



    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        Calendar fechaActual = Calendar.getInstance();

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());

        String strfecha = request.getParameter("fechaNacimiento");

        if (strfecha == null || strfecha.isEmpty()) {

            response.getWriter().println("Falta fecha de nacimiento, proporciónala en el URL");
            return;
        }
        try {
            Calendar fechaNacimiento = new GregorianCalendar();
            fechaNacimiento.setTime(formatter.parse(strfecha));

            int edad = fechaActual.get(Calendar.YEAR) - fechaNacimiento.get(Calendar.YEAR);

            if (fechaNacimiento.get(Calendar.MONTH) > fechaActual.get(Calendar.MONTH) ||
                    (fechaNacimiento.get(Calendar.MONTH) == fechaActual.get(Calendar.MONTH) &&
                            fechaNacimiento.get(Calendar.DAY_OF_MONTH) > fechaActual.get(Calendar.DAY_OF_MONTH))) {
                edad--;
            }

            response.getWriter().println("<h1>Edad Calculada</h1>");
            response.getWriter().println("Edad: " + edad + " años");
            response.getWriter().println();
            response.getWriter().println("<p>Servlet que calcula la edad, " +
                    "pasando como parámetro la fecha de nacimiento: " + formatter.toPattern());
        } catch (Exception e) {
            // Si hay algún error al calcular la edad, imprimir un mensaje de error
            response.getWriter().println("Error al calcular la edad: " + e.getMessage());
        }
    }
}

