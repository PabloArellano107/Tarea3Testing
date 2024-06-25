package com.example;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class ReservaManagerTest {

    @Test
    public void testAgregarReserva() {
        SalaManager salaManager = new SalaManager();
        UsuarioManager usuarioManager = new UsuarioManager();
        ReservaManager reservaManager = new ReservaManager(salaManager, usuarioManager);

        Sala sala = new Sala("1", "Sala A", "Edificio 1", false);
        Usuario usuario = new Usuario("1", "Juan", "IT", "Admin");
        salaManager.agregarSala(sala);
        usuarioManager.agregarUsuario(usuario);

        Reserva reserva = new Reserva("1", "1", LocalDate.now(), "Reunión de prueba");
        reservaManager.agregarReserva(reserva);
        assertEquals(reserva, reservaManager.obtenerReserva("1", "1", LocalDate.now()));
    }

    @Test
    public void testActualizarReserva() {
        SalaManager salaManager = new SalaManager();
        UsuarioManager usuarioManager = new UsuarioManager();
        ReservaManager reservaManager = new ReservaManager(salaManager, usuarioManager);

        Sala sala = new Sala("1", "Sala A", "Edificio 1", false);
        Usuario usuario = new Usuario("1", "Juan", "IT", "Admin");
        salaManager.agregarSala(sala);
        usuarioManager.agregarUsuario(usuario);

        Reserva reserva = new Reserva("1", "1", LocalDate.now(), "Reunión de prueba");
        reservaManager.agregarReserva(reserva);
        reserva.setDetalleReserva("Reunión actualizada");
        reservaManager.actualizarReserva(reserva);
        assertEquals("Reunión actualizada", reservaManager.obtenerReserva("1", "1", LocalDate.now()).getDetalleReserva());
    }

    @Test
    public void testEliminarReserva() {
        SalaManager salaManager = new SalaManager();
        UsuarioManager usuarioManager = new UsuarioManager();
        ReservaManager reservaManager = new ReservaManager(salaManager, usuarioManager);

        Sala sala = new Sala("1", "Sala A", "Edificio 1", false);
        Usuario usuario = new Usuario("1", "Juan", "IT", "Admin");
        salaManager.agregarSala(sala);
        usuarioManager.agregarUsuario(usuario);

        Reserva reserva = new Reserva("1", "1", LocalDate.now(), "Reunión de prueba");
        reservaManager.agregarReserva(reserva);
        reservaManager.eliminarReserva("1", "1", LocalDate.now());
        assertNull(reservaManager.obtenerReserva("1", "1", LocalDate.now()));
    }

    @Test
    public void testReservaSobreposicionUsuario() {
        SalaManager salaManager = new SalaManager();
        UsuarioManager usuarioManager = new UsuarioManager();
        ReservaManager reservaManager = new ReservaManager(salaManager, usuarioManager);

        Sala sala1 = new Sala("1", "Sala A", "Edificio 1", false);
        Usuario usuario1 = new Usuario("1", "Juan", "IT", "Admin");
        salaManager.agregarSala(sala1);
        usuarioManager.agregarUsuario(usuario1);

        Sala sala2 = new Sala("2", "Sala B", "Edificio 2", false);
        Usuario usuario2 = new Usuario("2", "María", "HR", "Manager");
        salaManager.agregarSala(sala2);
        usuarioManager.agregarUsuario(usuario2);

        Reserva reserva1 = new Reserva("1", "1", LocalDate.now(), "Reunión de prueba 1");
        reservaManager.agregarReserva(reserva1);

        Reserva reserva2 = new Reserva("2", "1", LocalDate.now(), "Reunión de prueba 2");
        assertThrows(IllegalArgumentException.class, () -> reservaManager.agregarReserva(reserva2));
    }
}


