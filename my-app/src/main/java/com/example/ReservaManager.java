package com.example;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReservaManager {
    private List<Reserva> reservas = new ArrayList<>();
    private SalaManager salaManager;
    private UsuarioManager usuarioManager;

    public ReservaManager(SalaManager salaManager, UsuarioManager usuarioManager) {
        this.salaManager = salaManager;
        this.usuarioManager = usuarioManager;
    }

    public void gestionarReservas(Scanner scanner) {
        while (true) {
            System.out.println("\n--- Gestión de Reservas ---");
            System.out.println("1. Agregar Reserva");
            System.out.println("2. Ver Reservas");
            System.out.println("3. Actualizar Reserva");
            System.out.println("4. Eliminar Reserva");
            System.out.println("5. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    agregarReserva(scanner);
                    break;
                case 2:
                    verReservas();
                    break;
                case 3:
                    actualizarReserva(scanner);
                    break;
                case 4:
                    eliminarReserva(scanner);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    private void agregarReserva(Scanner scanner) {
        System.out.print("Ingrese el código de la sala: ");
        String codigoSala = scanner.nextLine();
        if (salaManager.obtenerSala(codigoSala) == null) {
            System.out.println("La sala no existe.");
            return;
        }

        System.out.print("Ingrese el ID del usuario: ");
        String idUsuario = scanner.nextLine();
        if (usuarioManager.obtenerUsuario(idUsuario) == null) {
            System.out.println("El usuario no existe.");
            return;
        }

        System.out.print("Ingrese la fecha de la reserva (YYYY-MM-DD): ");
        String fechaStr = scanner.nextLine();
        LocalDate fecha = LocalDate.parse(fechaStr, DateTimeFormatter.ISO_LOCAL_DATE);

        // Verificar si ya existe una reserva para la misma sala en la misma fecha
        if (obtenerReserva(codigoSala, idUsuario, fecha) != null) {
            System.out.println("Ya existe una reserva para esta sala en esta fecha.");
            return;
        }

        System.out.print("Ingrese el detalle de la reserva: ");
        String detalleReserva = scanner.nextLine();

        Reserva reserva = new Reserva(codigoSala, idUsuario, fecha, detalleReserva);
        agregarReserva(reserva);
        System.out.println("Reserva agregada exitosamente.");
    }

    private void verReservas() {
        System.out.println("\n--- Lista de Reservas ---");
        for (Reserva reserva : reservas) {
            System.out.println(reserva);
        }
    }

    private void actualizarReserva(Scanner scanner) {
        System.out.print("Ingrese el código de la sala: ");
        String codigoSala = scanner.nextLine();
        System.out.print("Ingrese el ID del usuario: ");
        String idUsuario = scanner.nextLine();
        System.out.print("Ingrese la fecha de la reserva (YYYY-MM-DD): ");
        String fechaStr = scanner.nextLine();
        LocalDate fecha = LocalDate.parse(fechaStr, DateTimeFormatter.ISO_LOCAL_DATE);

        Reserva reserva = obtenerReserva(codigoSala, idUsuario, fecha);

        if (reserva == null) {
            System.out.println("Reserva no encontrada.");
            return;
        }

        System.out.print("Ingrese el nuevo detalle de la reserva (actual: " + reserva.getDetalleReserva() + "): ");
        String detalleReserva = scanner.nextLine();

        reserva.setDetalleReserva(detalleReserva);
        actualizarReserva(reserva);
        System.out.println("Reserva actualizada exitosamente.");
    }

    private void eliminarReserva(Scanner scanner) {
        System.out.print("Ingrese el código de la sala: ");
        String codigoSala = scanner.nextLine();
        System.out.print("Ingrese el ID del usuario: ");
        String idUsuario = scanner.nextLine();
        System.out.print("Ingrese la fecha de la reserva (YYYY-MM-DD): ");
        String fechaStr = scanner.nextLine();
        LocalDate fecha = LocalDate.parse(fechaStr, DateTimeFormatter.ISO_LOCAL_DATE);

        eliminarReserva(codigoSala, idUsuario, fecha);
        System.out.println("Reserva eliminada exitosamente.");
    }

    public void agregarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public Reserva obtenerReserva(String codigoSala, String idUsuario, LocalDate fecha) {
        for (Reserva reserva : reservas) {
            if (reserva.getCodigoSala().equals(codigoSala) &&
                reserva.getIdUsuario().equals(idUsuario) &&
                reserva.getFecha().equals(fecha)) {
                return reserva;
            }
        }
        return null;
    }

    public void actualizarReserva(Reserva reserva) {
        Reserva existente = obtenerReserva(reserva.getCodigoSala(), reserva.getIdUsuario(), reserva.getFecha());
        if (existente != null) {
            existente.setDetalleReserva(reserva.getDetalleReserva());
        }
    }

    public void eliminarReserva(String codigoSala, String idUsuario, LocalDate fecha) {
        Reserva reserva = obtenerReserva(codigoSala, idUsuario, fecha);
        if (reserva != null) {
            reservas.remove(reserva);
        }
    }
}


