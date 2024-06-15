package com.axelq.servletdemo;

import java.sql.SQLException;
import java.util.List;

public interface DepartamentoDAO {
    void insertar(Departamento departamento) throws SQLException;
    void actualizar(Departamento departamento) throws SQLException;
    void eliminar(int id) throws SQLException;
    Departamento obtener(int id) throws SQLException;
    List<Departamento> obtenerTodos() throws SQLException;
}
