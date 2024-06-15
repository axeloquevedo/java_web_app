package com.axelq.servletdemo;

public class Departamento {
    private int id;
    private String nombre;

    // Añado Constructores 13Jun
    public Departamento() {}

    public Departamento(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
