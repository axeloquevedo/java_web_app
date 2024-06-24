package com.axelq.servletdemo;

import java.sql.SQLException;
import java.util.List;

public interface ProfesorDAO {
    void insertar(Profesor profesor) throws SQLException;
    void actualizar(Profesor profesor) throws SQLException;
    void eliminar(int id) throws SQLException;
    Profesor obtener(int id) throws SQLException;
    List<Profesor> obtenerTodos() throws SQLException;
}

