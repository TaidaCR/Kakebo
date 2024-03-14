package src;

import java.rmi.StubNotFoundException;
import java.time.LocalDate;
import java.util.Scanner;

import src.entities.Cuenta;
import src.entities.Movimiento;

public class Main {
    public static void main(String[] args) {
        Cuenta acumulador = new Cuenta();
        boolean seguirEnBucle = true;
        Scanner scanner = new Scanner(System.in);
        

        while (seguirEnBucle) {
            System.out.print("Quiere hacer Ingreso / Gasto / Salir?");
            String respuesta = scanner.nextLine();
            float cantidad;
            String asunto;
            LocalDate fecha;


            switch (respuesta.toUpperCase()) {
                
                case "I":
                    System.out.print("Introduce la cantidad: ");
                    cantidad = scanner.nextFloat();
                    scanner.nextLine();
                    acumulador.ingresar(cantidad);

                    System.out.print("Asunto: ");
                    asunto = scanner.nextLine();

                    System.out.print("Fecha: ");
                    fecha=LocalDate.parse(scanner.nextLine());
                    
                    Movimiento mv = new Movimiento(fecha, asunto, cantidad);

                    break;
                case "G":
                    System.out.print("Introduce la cantidad: ");
                    cantidad = scanner.nextFloat();
                    scanner.nextLine();
                    acumulador.gastar(cantidad);
                    break;
                case "S":
                    seguirEnBucle = false;
                    break;
                default: // Si no es I G o S habra que volver a pedir
                    System.out.print("Valor erróneo.");

            }
        }

        /*
         * Imprimir Total ingresos
         * Imprimir Total gastos
         * Imprimir Balance
         */
        System.out.printf("Ingresos: %15.2f€", acumulador.getTotalIngresos());
        System.out.printf("Gastos: %15.2f€", acumulador.getTotalGastos());
        System.out.printf("Balance: %15.2f€", acumulador.getTotalIngresos() - acumulador.getTotalGastos());
        System.out.printf("Saldo: %15.2f€", acumulador.getSaldo());
    }
}
        

        
        

