package com.example;
public class Sala {
    private String codigo;
    private String nombre;
    private String ubicacion;
    private boolean reservada;

    // Constructor
    public Sala(String codigo, String nombre, String ubicacion, boolean reservada) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.reservada = reservada;
    }

    // Getters y setters
    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public boolean isReservada() {
        return reservada;
    }

    public void setReservada(boolean reservada) {
        this.reservada = reservada;
    }

    @Override
    public String toString() {
        return "Sala{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", reservada=" + reservada +
                '}';
    }
}

