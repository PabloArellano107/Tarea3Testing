package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SalaManagerTest {

    @Test
    public void testAgregarSala() {
        SalaManager manager = new SalaManager();
        Sala sala = new Sala("1", "Sala A", "Edificio 1", false);
        manager.agregarSala(sala);
        assertEquals(sala, manager.obtenerSala("1"));
    }

    @Test
    public void testActualizarSala() {
        SalaManager manager = new SalaManager();
        Sala sala = new Sala("1", "Sala A", "Edificio 1", false);
        manager.agregarSala(sala);
        sala.setNombre("Sala B");
        manager.actualizarSala(sala);
        assertEquals("Sala B", manager.obtenerSala("1").getNombre());
    }

    @Test
    public void testEliminarSala() {
        SalaManager manager = new SalaManager();
        Sala sala = new Sala("1", "Sala A", "Edificio 1", false);
        manager.agregarSala(sala);
        manager.eliminarSala("1");
        assertNull(manager.obtenerSala("1"));
    }

    @Test
    public void testAgregarSalaDuplicada() {
        SalaManager manager = new SalaManager();
        Sala sala = new Sala("1", "Sala A", "Edificio 1", false);
        manager.agregarSala(sala); // Agregar la sala por primera vez
        // Intentar agregar la misma sala nuevamente debería lanzar una excepción
        assertThrows(IllegalArgumentException.class, () -> manager.agregarSala(sala));
}

}


