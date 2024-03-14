package src.entities;

import java.time.LocalDate;

public class Gasto extends Movimiento{
    private CategoriaGasto categoria;

    public Gasto(LocalDate fecha, String asunto, float valor, CategoriaGasto categoria){
    super(fecha, asunto, valor);
    this.categoria = categoria;
    }

    public CategoriaGasto getCategoria(){
        return categoria;
    }
}
