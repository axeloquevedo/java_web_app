package com.axelq.servletdemo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GradoDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/universidad";
    private static final String USER = "root";
    private static final String PASSWORD = "A&Quevedo2003";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<Grado> getAllGrados() {
        List<Grado> grados = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT id, nombre FROM grado")) {

            while (rs.next()) {
                Grado grado = new Grado();
                grado.setId(rs.getInt("id"));
                grado.setNombre(rs.getString("nombre"));
                grados.add(grado);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return grados;
    }
}
