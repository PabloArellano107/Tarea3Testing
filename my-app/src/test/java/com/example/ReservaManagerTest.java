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
    public void testLeerReserva() {
        SalaManager salaManager = new SalaManager();
        UsuarioManager usuarioManager = new UsuarioManager();
        ReservaManager reservaManager = new ReservaManager(salaManager, usuarioManager);

        Sala sala = new Sala("1", "Sala A", "Edificio 1", false);
        Usuario usuario = new Usuario("1", "Juan", "IT", "Admin");
        salaManager.agregarSala(sala);
        usuarioManager.agregarUsuario(usuario);

        LocalDate fechaReserva = LocalDate.now();
        Reserva reserva = new Reserva("1", "1", fechaReserva, "Reunión de prueba");
        reservaManager.agregarReserva(reserva);

        Reserva obtenida = reservaManager.obtenerReserva("1", "1", fechaReserva);
        assertNotNull(obtenida);
        assertEquals("1", obtenida.getCodigoSala());
        assertEquals("1", obtenida.getIdUsuario());
        assertEquals(fechaReserva, obtenida.getFecha());
        assertEquals("Reunión de prueba", obtenida.getDetalleReserva());
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
}

