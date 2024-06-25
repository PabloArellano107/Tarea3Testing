package com.example;
public class Usuario {
    private String id;
    private String nombre;
    private String departamento;
    private String descripcion;

    // Constructor
    public Usuario(String id, String nombre, String departamento, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.departamento = departamento;
        this.descripcion = descripcion;
    }

    // Getters y setters
    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", departamento='" + departamento + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
