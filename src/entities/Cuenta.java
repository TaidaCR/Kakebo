package src.entities;

import java.util.ArrayList;

import java.time.LocalDate;

public class Cuenta {
    private float saldo;
    private float ingresos;
    private float gastos;
    private ArrayList <Ingreso> listaIngresos = new ArrayList<>();
    


    public Cuenta(float saldo) {
        this.saldo = saldo;
        ingresos = 0;
        gastos = 0;
    }

    public Cuenta() {
        this(0);  // equivale a llamar a Cuenta(0)
    }

    public float getSaldo() {
        return saldo;
    }

    public void ingresar(float ingreso, CategoriaIngreso categoria, LocalDate fecha, String asunto) {
        saldo += ingreso;
        ingresos += ingreso;
    }

    public void gastar(float gasto) {
        saldo -= gasto;
        gastos += gasto;
    }

    public float getTotalIngresos() {
        return ingresos;
    }

    public float getTotalGastos() {
        return gastos;
    }

    public void addIngreso(LocalDate fecha, String asunto, float valor, CategoriaIngreso categoria){
        Ingreso ingreso = new Ingreso(fecha,asunto, valor, categoria);
        listaIngresos.add(ingreso);
    }

    public ArrayList<Ingreso> getIngresos(){
        return listaIngresos;
            
        
    }
    
}
