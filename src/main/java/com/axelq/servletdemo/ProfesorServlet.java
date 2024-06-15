package com.axelq.servletdemo;

import java.io.*;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "ProfesorServlets", value = "/ProfesorServlet")
public class ProfesorServlet extends HttpServlet {
    private ProfesorDAO profesorDAO;

    public void init() {
        profesorDAO = new ProfesorDAOImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("insert".equals(action)) {
            insertarProfesor(request, response);
        } else if ("update".equals(action)) {
            actualizarProfesor(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("delete".equals(action)) {
            eliminarProfesor(request, response);
        } else if ("list".equals(action)) {
            listarProfesores(request, response);
        }
    }

    private void insertarProfesor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idDepartamento = Integer.parseInt(request.getParameter("id_departamento"));
        int idPersona = Integer.parseInt(request.getParameter("id_persona"));
        Profesor profesor = new Profesor();
        profesor.setIdDepartamento(idDepartamento);
        profesor.setIdPersona(idPersona);

        try {
            profesorDAO.insertar(profesor);
            response.sendRedirect("profesores.jsp");
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    private void actualizarProfesor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int idDepartamento = Integer.parseInt(request.getParameter("id_departamento"));
        int idPersona = Integer.parseInt(request.getParameter("id_persona"));
        Profesor profesor = new Profesor(id, idDepartamento, idPersona);

        try {
            profesorDAO.actualizar(profesor);
            response.sendRedirect("profesores.jsp");
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    private void eliminarProfesor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        try {
            profesorDAO.eliminar(id);
            response.sendRedirect("profesores.jsp");
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    private void listarProfesores(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Profesor> listaProfesores = profesorDAO.obtenerTodos();
            request.setAttribute("listaProfesores", listaProfesores);
            RequestDispatcher dispatcher = request.getRequestDispatcher("profesores.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}
