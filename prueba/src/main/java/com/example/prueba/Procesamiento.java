package com.example.prueba;

import java.time.LocalDate;

import com.example.prueba.objetos.Operacion;
import com.example.prueba.objetos.Tarjeta;

public class Procesamiento {
    public static void main(String[] args) {
        LocalDate fechaVencimiento = LocalDate.now().plusMonths(1);
        Tarjeta tarjeta1 = new Tarjeta("VISA", "1234", "Juan Perez", fechaVencimiento);
        Tarjeta tarjeta2 = new Tarjeta("NARA", "5678", "María Perez", fechaVencimiento);

        Operacion operacion1 = new Operacion(tarjeta1, 800);
        Operacion operacion2 = new Operacion(tarjeta2, 1800);

        System.out.println("Informacion de tarjeta: " + tarjeta1.getMarca() + ", " + tarjeta1.getNumero() + ", " + tarjeta1.getCardholder());
        System.out.println("Operacion es valida: " + (operacion1.esValida() ? "Sí" : "No"));
        System.out.println("Tarjeta valida para operar: " + (tarjeta1.esValidaParaOperar() ? "Sí" : "No"));

        Tarjeta otraTarjeta = new Tarjeta("VISA", "5678", "María Gómez", fechaVencimiento);
        System.out.println("Tarjeta diferente: " + (tarjeta1.equals(otraTarjeta) ? "No" : "Sí"));

        if (operacion1.esValida()) {
            double tasa1 = operacion1.calcularTasa();
            System.out.println("Tasa de operación: " + tasa1 + "%");
        } else {
            throw new IllegalArgumentException("La operacion no es valida y no se puede realizar.");
        }

        System.out.println("Informacion de tarjeta: " + tarjeta2.getMarca() + ", " + tarjeta2.getNumero() + ", " + tarjeta2.getCardholder());
        System.out.println("Operacion valida: " + (operacion2.esValida() ? "Sí" : "No"));
        System.out.println("Tarjeta valida para operar: " + (tarjeta2.esValidaParaOperar() ? "Sí" : "No"));

        if (operacion2.esValida()) {
            double tasa2 = operacion2.calcularTasa();
            System.out.println("Tasa de operacion: " + tasa2 + "%");
        } else {
            throw new IllegalArgumentException("La operacion no es valida y no se puede realizar.");
        }
    }
}
