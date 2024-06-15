package com.axelq.servletdemo;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Class.forName;

@WebServlet(name = "PersonaServlet", value = "/PersonaServlet")

public class PersonaServlet extends HttpServlet {

    private static final String URL = "jdbc:mysql://localhost:3306/universidad";
    private static final String USER = "root";
    private static final String PASSWORD = "A&Quevedo2003";

    protected  void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }

        try {
            switch (action) {
                case "new":
                    showNewForm(request, response);
                    break;
                case "insert":
                    insertPersona(request, response);
                    break;
                case "delete":
                    deletePersona(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "update":
                    updatePersona(request, response);
                    break;
                default:
                    listPersonas(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listPersonas(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        List<Persona> listPersonas = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT nombre, apellido1, direccion, telefono, sexo FROM persona")) {

            while (rs.next()) {
                Persona persona = new Persona();
                persona.setNombre(rs.getString("nombre"));
                persona.setApellido1(rs.getString("apellido1"));
                persona.setDireccion(rs.getString("direccion"));
                persona.setTelefono(rs.getString("telefono"));
                persona.setSexo(rs.getString("sexo"));
                listPersonas.add(persona);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("listPersonas", listPersonas);
        request.getRequestDispatcher("persona-list.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("persona-form.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String nombre = request.getParameter("nombre");
        Persona existingPersona = new Persona();

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM persona WHERE nombre = ?")) {
            pstmt.setString(1, nombre);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                existingPersona.setNombre(rs.getString("nombre"));
                existingPersona.setApellido1(rs.getString("apellido1"));
                existingPersona.setDireccion(rs.getString("direccion"));
                existingPersona.setTelefono(rs.getString("telefono"));
                existingPersona.setSexo(rs.getString("sexo"));
            }
        }

        request.setAttribute("persona", existingPersona);
        request.getRequestDispatcher("persona-form.jsp").forward(request, response);
    }

    private void insertPersona(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String nombre = request.getParameter("nombre");
        String apellido1 = request.getParameter("apellido1");
        String direccion = request.getParameter("direccion");
        String telefono = request.getParameter("telefono");
        String sexo = request.getParameter("sexo");

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement("INSERT INTO persona (nombre, apellido1, direccion, telefono, sexo) VALUES (?, ?, ?, ?, ?)")) {
            pstmt.setString(1, nombre);
            pstmt.setString(2, apellido1);
            pstmt.setString(3, direccion);
            pstmt.setString(4, telefono);
            pstmt.setString(5, sexo);
            pstmt.executeUpdate();
        }

        response.sendRedirect("PersonaServlet");
    }

    private void updatePersona(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String nombre = request.getParameter("nombre");
        String apellido1 = request.getParameter("apellido1");
        String direccion = request.getParameter("direccion");
        String telefono = request.getParameter("telefono");
        String sexo = request.getParameter("sexo");

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement("UPDATE persona SET apellido1 = ?, direccion = ?, telefono = ?, sexo = ? WHERE nombre = ?")) {
            pstmt.setString(1, apellido1);
            pstmt.setString(2, direccion);
            pstmt.setString(3, telefono);
            pstmt.setString(4, sexo);
            pstmt.setString(5, nombre);
            pstmt.executeUpdate();
        }

        response.sendRedirect("PersonaServlet");
    }

    private void deletePersona(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String nombre = request.getParameter("nombre");

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement("DELETE FROM persona WHERE nombre = ?")) {
            pstmt.setString(1, nombre);
            pstmt.executeUpdate();
        }

        response.sendRedirect("PersonaServlet");
    }


}
