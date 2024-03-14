package test;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Test;

import src.entities.CategoriaGasto;
import src.entities.Gasto;

public class TestGasto {
    @Test
    public void testCreateGasto(){
        Gasto g = new Gasto(LocalDate.of(1993,9,23), "Buceo",120,CategoriaGasto.OCIO);

        assertEquals(LocalDate.of(1993,9,23),g.getFecha());
        assertEquals("Buceo", g.getAsunto());
        assertEquals(120, g.getValor(),0.0001);
        assertEquals(CategoriaGasto.OCIO, g.getCategoria());

    }
}
