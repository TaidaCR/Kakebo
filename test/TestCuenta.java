package test;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Test;

import src.entities.CategoriaIngreso;
import src.entities.Cuenta;
import src.entities.Ingreso;

public class TestCuenta {
    @Test
    public void testCreateCuentaWithSaldo() {
        Cuenta cuenta = new Cuenta(100);

        assertEquals(cuenta.getSaldo(), 100, 0.00001);
    }

    @Test
    public void testCreateCuentaWithoutSaldo() {
        Cuenta cuenta = new Cuenta();

        assertEquals(cuenta.getSaldo(), 0, 0.00001);
    }

    @Test
    public void testIngresar(){
        Cuenta cuenta = new Cuenta(100);

        cuenta.ingresar(10, CategoriaIngreso.OTROS,LocalDate.of(1990,11,11),"Clases particulares");
        cuenta.ingresar(20, CategoriaIngreso.NEGOCIOS, LocalDate.of(1990,11,12), "Otro concepto");
        

        assertEquals(cuenta.getSaldo(), 130, 0.000001);

        Ingreso[] movimientos = cuenta.getIngresos();
        //getIngresos se crea en cuenta

        assertEquals(movimientos.length,2);
        assertEquals(movimientos[0].getCategoria(), CategoriaIngreso.OTROS);
        assertEquals(movimientos[1].getCategoria(), CategoriaIngreso.NEGOCIOS);
        assertEquals(movimientos[0].getFecha(), LocalDate.of(1990,11,11));
        assertEquals(movimientos[1].getFecha(), LocalDate.of(1990,11,12));
        assertEquals(movimientos[0].getValor(), 10, 0.0001);
        assertEquals(movimientos[1].getValor(), 20, 0.0001);
        assertEquals(movimientos[0].getAsunto(), "Clases particulares");
        assertEquals(movimientos[1].getAsunto(), "Otro concepto");
        //PASAR A VERDE COMPLETANDO CUENTA (LOS DEMAS TEST SE VAN A DESBARAJUSTAR)
    }

    @Test
    public void testGastar(){
        Cuenta cuenta = new Cuenta(100);

        cuenta.gastar(10);
        assertEquals(cuenta.getSaldo(), 90, 0.000002);
    }

    @Test
    public void testIngresosGastos(){
        Cuenta cuenta = new Cuenta(100);

        cuenta.ingresar(10, CategoriaIngreso.OTROS,LocalDate.of(1990,11,11),"Clases particulares");
        cuenta.ingresar(20, CategoriaIngreso.OTROS,LocalDate.of(1990,11,12),"Clases particulares");
        cuenta.gastar(15);

        assertEquals(115, cuenta.getSaldo(), 0.000001);
        assertEquals(30, cuenta.getTotalIngresos(), 0.00001);
        assertEquals(15, cuenta.getTotalGastos(), 0.00001);
    }

    @Test
    public void testInicializaFloatsACero () {
        Cuenta cuenta = new Cuenta(100);

        assertEquals(cuenta.getSaldo(), 100, 0.0001);        
        assertEquals(cuenta.getTotalIngresos(), 0, 0.0001);        
        assertEquals(cuenta.getTotalGastos(), 0, 0.0001);
        
    }

}