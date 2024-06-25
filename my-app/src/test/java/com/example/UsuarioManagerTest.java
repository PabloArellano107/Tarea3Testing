package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UsuarioManagerTest {

    @Test
    public void testAgregarUsuario() {
        UsuarioManager manager = new UsuarioManager();
        Usuario usuario = new Usuario("1", "Juan", "IT", "Admin");
        manager.agregarUsuario(usuario);
        assertEquals(usuario, manager.obtenerUsuario("1"));
    }

    @Test
    public void testLeerUsuario() {
        UsuarioManager manager = new UsuarioManager();
        Usuario usuario = new Usuario("1", "Juan", "IT", "Admin");
        manager.agregarUsuario(usuario);
        Usuario obtenido = manager.obtenerUsuario("1");
        assertNotNull(obtenido);
        assertEquals("1", obtenido.getId());
        assertEquals("Juan", obtenido.getNombre());
        assertEquals("IT", obtenido.getDepartamento());
        assertEquals("Admin", obtenido.getDescripcion());
    }

    @Test
    public void testActualizarUsuario() {
        UsuarioManager manager = new UsuarioManager();
        Usuario usuario = new Usuario("1", "Juan", "IT", "Admin");
        manager.agregarUsuario(usuario);
        usuario.setNombre("Pedro");
        manager.actualizarUsuario(usuario);
        assertEquals("Pedro", manager.obtenerUsuario("1").getNombre());
    }

    @Test
    public void testEliminarUsuario() {
        UsuarioManager manager = new UsuarioManager();
        Usuario usuario = new Usuario("1", "Juan", "IT", "Admin");
        manager.agregarUsuario(usuario);
        manager.eliminarUsuario("1");
        assertNull(manager.obtenerUsuario("1"));
    }
}


