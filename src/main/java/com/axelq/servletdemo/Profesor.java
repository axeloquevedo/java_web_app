package com.axelq.servletdemo;

public class Profesor {
    private int id;
    private int idDepartamento;
    private int idPersona;

    public Profesor() {}

    public Profesor(int id, int idDepartamento, int idPersona) {
        this.id = id;
        this.idDepartamento = idDepartamento;
        this.idPersona = idPersona;
    }

    // 13Jun
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }
}
