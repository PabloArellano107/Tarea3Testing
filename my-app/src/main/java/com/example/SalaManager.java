package com.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SalaManager {
    private List<Sala> salas = new ArrayList<>();

    public void gestionarSalas(Scanner scanner) {
        while (true) {
            System.out.println("\n--- Gestión de Salas ---");
            System.out.println("1. Agregar Sala");
            System.out.println("2. Ver Salas");
            System.out.println("3. Actualizar Sala");
            System.out.println("4. Eliminar Sala");
            System.out.println("5. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    agregarSala(scanner);
                    break;
                case 2:
                    verSalas();
                    break;
                case 3:
                    actualizarSala(scanner);
                    break;
                case 4:
                    eliminarSala(scanner);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    private void agregarSala(Scanner scanner) {
        System.out.print("Ingrese el código de la sala: ");
        String codigo = scanner.nextLine();
    
        // Verificar si ya existe una sala con el mismo código
        for (Sala s : salas) {
            if (s.getCodigo().equals(codigo)) {
                System.out.println("Ya existe una sala con el código proporcionado: " + codigo);
                return; // Regresar al menú de gestión de salas
            }
        }
    
        System.out.print("Ingrese el nombre de la sala: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la ubicación de la sala: ");
        String ubicacion = scanner.nextLine();
        System.out.print("¿Está reservada la sala? (true/false): ");
        boolean reservada = scanner.nextBoolean();
        scanner.nextLine(); // Limpiar el buffer después de leer boolean
    
        // Crear la sala y agregarla si no hay duplicados
        Sala sala = new Sala(codigo, nombre, ubicacion, reservada);
        agregarSala(sala);
        System.out.println("Sala agregada exitosamente.");
    }
    
    

    private void verSalas() {
        System.out.println("\n--- Lista de Salas ---");
        for (Sala sala : salas) {
            System.out.println(sala);
        }
    }

    private void actualizarSala(Scanner scanner) {
        System.out.print("Ingrese el código de la sala a actualizar: ");
        String codigo = scanner.nextLine();
        Sala sala = obtenerSala(codigo);

        if (sala == null) {
            System.out.println("Sala no encontrada.");
            return;
        }

        System.out.print("Ingrese el nuevo nombre de la sala (actual: " + sala.getNombre() + "): ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la nueva ubicación de la sala (actual: " + sala.getUbicacion() + "): ");
        String ubicacion = scanner.nextLine();
        System.out.print("¿Está reservada la sala? (true/false, actual: " + sala.isReservada() + "): ");
        boolean reservada = scanner.nextBoolean();

        sala.setNombre(nombre);
        sala.setUbicacion(ubicacion);
        sala.setReservada(reservada);
        actualizarSala(sala);
        System.out.println("Sala actualizada exitosamente.");
    }

    private void eliminarSala(Scanner scanner) {
        System.out.print("Ingrese el código de la sala a eliminar: ");
        String codigo = scanner.nextLine();
        eliminarSala(codigo);
        System.out.println("Sala eliminada exitosamente.");
    }

    public void agregarSala(Sala sala) {
        salas.add(sala);
    }

    public Sala obtenerSala(String codigo) {
        for (Sala sala : salas) {
            if (sala.getCodigo().equals(codigo)) {
                return sala;
            }
        }
        return null;
    }

    public void actualizarSala(Sala sala) {
        Sala existente = obtenerSala(sala.getCodigo());
        if (existente != null) {
            existente.setNombre(sala.getNombre());
            existente.setUbicacion(sala.getUbicacion());
            existente.setReservada(sala.isReservada());
        }
    }

    public void eliminarSala(String codigo) {
        Sala sala = obtenerSala(codigo);
        if (sala != null) {
            salas.remove(sala);
        }
    }
}
