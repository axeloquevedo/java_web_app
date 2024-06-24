package com.axelq.servletdemo;
import java.io.*;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

import jakarta.servlet.annotation.WebServlet;

@WebServlet(name = "GradoServlet", value = "/GradoServlet")
public class GradoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private GradoDAO gradoDAO;

    public void init() {
        gradoDAO = new GradoDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
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
                    insertGrado(request, response);
                    break;
                case "delete":
                    deleteGrado(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "update":
                    updateGrado(request, response);
                    break;
                default:
                    listGrados(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listGrados(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Grado> listGrados = gradoDAO.getAllGrados();
        request.setAttribute("listGrados", listGrados);
        request.getRequestDispatcher("grado-list.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("grado-form.jsp").forward(request, response);
    }

    private void insertGrado(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
    }

    private void updateGrado(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
    }

    private void deleteGrado(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
    }
}
