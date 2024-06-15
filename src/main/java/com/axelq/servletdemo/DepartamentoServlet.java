package com.axelq.servletdemo;
import java.io.*;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(name = "DepartamentoServlet", value = "/DepartamentoServlet")
public class DepartamentoServlet extends HttpServlet{
    private DepartamentoDAO departamentoDAO;

    public void init() {
        departamentoDAO = new DepartamentoDAOImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("insert".equals(action)) {
            insertarDepartamento(request, response);
        } else if ("update".equals(action)) {
            actualizarDepartamento(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("delete".equals(action)) {
            eliminarDepartamento(request, response);
        } else if ("list".equals(action)) {
            listarDepartamentos(request, response);
        }
    }

    private void insertarDepartamento(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        Departamento departamento = new Departamento();
        departamento.setNombre(nombre);

        try {
            departamentoDAO.insertar(departamento);
            response.sendRedirect("departamentos.jsp");
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    private void actualizarDepartamento(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        Departamento departamento = new Departamento(id, nombre);

        try {
            departamentoDAO.actualizar(departamento);
            response.sendRedirect("departamentos.jsp");
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    private void eliminarDepartamento(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        try {
            departamentoDAO.eliminar(id);
            response.sendRedirect("departamentos.jsp");
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    private void listarDepartamentos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Departamento> listaDepartamentos = departamentoDAO.obtenerTodos();
            request.setAttribute("listaDepartamentos", listaDepartamentos);
            RequestDispatcher dispatcher = request.getRequestDispatcher("departamentos.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}
