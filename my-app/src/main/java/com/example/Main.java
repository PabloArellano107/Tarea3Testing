package com.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SalaManager salaManager = new SalaManager();
        UsuarioManager usuarioManager = new UsuarioManager();
        ReservaManager reservaManager = new ReservaManager(salaManager, usuarioManager);

        while (true) {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Gestión de Usuarios");
            System.out.println("2. Gestión de Salas");
            System.out.println("3. Gestión de Reservas");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    usuarioManager.gestionarUsuarios(scanner);
                    break;
                case 2:
                    salaManager.gestionarSalas(scanner);
                    break;
                case 3:
                    reservaManager.gestionarReservas(scanner);
                    break;
                case 4:
                    System.out.println("Saliendo del sistema...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}

