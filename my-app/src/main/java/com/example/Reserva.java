package com.example;
import java.time.LocalDate;

public class Reserva {
    private String codigoSala;
    private String idUsuario;
    private LocalDate fecha;
    private String detalleReserva;

    // Constructor
    public Reserva(String codigoSala, String idUsuario, LocalDate fecha, String detalleReserva) {
        this.codigoSala = codigoSala;
        this.idUsuario = idUsuario;
        this.fecha = fecha;
        this.detalleReserva = detalleReserva;
    }

    // Getters y setters
    public String getCodigoSala() {
        return codigoSala;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getDetalleReserva() {
        return detalleReserva;
    }

    public void setDetalleReserva(String detalleReserva) {
        this.detalleReserva = detalleReserva;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "codigoSala='" + codigoSala + '\'' +
                ", idUsuario='" + idUsuario + '\'' +
                ", fecha=" + fecha +
                ", detalleReserva='" + detalleReserva + '\'' +
                '}';
    }
}
