package com.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UsuarioManager {
    private List<Usuario> usuarios = new ArrayList<>();

    public void gestionarUsuarios(Scanner scanner) {
        while (true) {
            System.out.println("\n--- Gestión de Usuarios ---");
            System.out.println("1. Agregar Usuario");
            System.out.println("2. Ver Usuarios");
            System.out.println("3. Actualizar Usuario");
            System.out.println("4. Eliminar Usuario");
            System.out.println("5. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    agregarUsuario(scanner);
                    break;
                case 2:
                    verUsuarios();
                    break;
                case 3:
                    actualizarUsuario(scanner);
                    break;
                case 4:
                    eliminarUsuario(scanner);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    private void agregarUsuario(Scanner scanner) {
        System.out.print("Ingrese el ID del usuario: ");
        String id = scanner.nextLine();
        System.out.print("Ingrese el nombre del usuario: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el departamento del usuario: ");
        String departamento = scanner.nextLine();
        System.out.print("Ingrese la descripción del usuario: ");
        String descripcion = scanner.nextLine();

        Usuario usuario = new Usuario(id, nombre, departamento, descripcion);
        agregarUsuario(usuario);
        System.out.println("Usuario agregado exitosamente.");
    }

    private void verUsuarios() {
        System.out.println("\n--- Lista de Usuarios ---");
        for (Usuario usuario : usuarios) {
            System.out.println(usuario);
        }
    }

    private void actualizarUsuario(Scanner scanner) {
        System.out.print("Ingrese el ID del usuario a actualizar: ");
        String id = scanner.nextLine();
        Usuario usuario = obtenerUsuario(id);

        if (usuario == null) {
            System.out.println("Usuario no encontrado.");
            return;
        }

        System.out.print("Ingrese el nuevo nombre del usuario (actual: " + usuario.getNombre() + "): ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el nuevo departamento del usuario (actual: " + usuario.getDepartamento() + "): ");
        String departamento = scanner.nextLine();
        System.out.print("Ingrese la nueva descripción del usuario (actual: " + usuario.getDescripcion() + "): ");
        String descripcion = scanner.nextLine();

        usuario.setNombre(nombre);
        usuario.setDepartamento(departamento);
        usuario.setDescripcion(descripcion);
        actualizarUsuario(usuario);
        System.out.println("Usuario actualizado exitosamente.");
    }

    private void eliminarUsuario(Scanner scanner) {
        System.out.print("Ingrese el ID del usuario a eliminar: ");
        String id = scanner.nextLine();
        eliminarUsuario(id);
        System.out.println("Usuario eliminado exitosamente.");
    }

    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public Usuario obtenerUsuario(String id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId().equals(id)) {
                return usuario;
            }
        }
        return null;
    }

    public void actualizarUsuario(Usuario usuario) {
        Usuario existente = obtenerUsuario(usuario.getId());
        if (existente != null) {
            existente.setNombre(usuario.getNombre());
            existente.setDepartamento(usuario.getDepartamento());
            existente.setDescripcion(usuario.getDescripcion());
        }
    }

    public void eliminarUsuario(String id) {
        Usuario usuario = obtenerUsuario(id);
        if (usuario != null) {
            usuarios.remove(usuario);
        }
    }
}

