package src.entities;
import java.time.LocalDate;

public class Movimiento {
    private LocalDate fecha;
    private String asunto;
    private float valor; 
    

    public Movimiento (LocalDate fecha, String asunto, float valor){
        this.fecha = fecha;
        this.asunto = asunto;
        this.valor = valor;
        
    }

    public Movimiento (String fecha, String asunto, float valor){
        this(LocalDate.parse(fecha), asunto, valor);
    }

    //METE LA FECHA AUTOMATICAMENTE
    public Movimiento (String asunto, float valor){
        this(LocalDate.now(), asunto, valor);
    }

    public LocalDate getFecha(){
        return fecha;
    }

    public String getAsunto(){
        return asunto;
    }

    public float getValor(){
        return valor;
    }
}
