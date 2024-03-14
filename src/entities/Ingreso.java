package src.entities;

import java.time.LocalDate;

public class Ingreso extends Movimiento {
    private CategoriaIngreso categoria;

    public Ingreso(LocalDate fecha, String asunto, float valor, CategoriaIngreso categoria){
        super(fecha, asunto, valor);
        this.categoria = categoria;

    }

    public CategoriaIngreso getCategoria(){
        return categoria;
    }
}
