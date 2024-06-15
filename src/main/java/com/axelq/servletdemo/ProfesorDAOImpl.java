package com.axelq.servletdemo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfesorDAOImpl implements ProfesorDAO{
    @Override
    public void insertar(Profesor profesor) throws SQLException {
        String sql = "INSERT INTO profesor (id_departamento, id_persona) VALUES (?, ?)";
        try (Connection conn = ConexionMySQL.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, profesor.getIdDepartamento());
            stmt.setInt(2, profesor.getIdPersona());
            stmt.executeUpdate();
        }
    }

    @Override
    public void actualizar(Profesor profesor) throws SQLException {
        String sql = "UPDATE profesor SET id_departamento = ?, id_persona = ? WHERE id = ?";
        try (Connection conn = ConexionMySQL.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, profesor.getIdDepartamento());
            stmt.setInt(2, profesor.getIdPersona());
            stmt.setInt(3, profesor.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM profesor WHERE id = ?";
        try (Connection conn = ConexionMySQL.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public Profesor obtener(int id) throws SQLException {
        String sql = "SELECT * FROM profesor WHERE id = ?";
        try (Connection conn = ConexionMySQL.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Profesor(rs.getInt("id"), rs.getInt("id_departamento"), rs.getInt("id_persona"));
                }
            }
        }
        return null;
    }

    @Override
    public List<Profesor> obtenerTodos() throws SQLException {
        List<Profesor> profesores = new ArrayList<>();
        String sql = "SELECT * FROM profesor";
        try (Connection conn = ConexionMySQL.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                profesores.add(new Profesor(rs.getInt("id"), rs.getInt("id_departamento"), rs.getInt("id_persona")));
            }
        }
        return profesores;
    }
}
