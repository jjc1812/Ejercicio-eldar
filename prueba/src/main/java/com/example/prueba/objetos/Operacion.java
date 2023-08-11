package com.example.prueba.objetos;

import java.time.LocalDate;

public class Operacion {
    private Tarjeta tarjeta;
    private double monto;

    public Operacion(Tarjeta tarjeta, double monto) {
        this.tarjeta = tarjeta;
        this.monto = monto;
    }

    public boolean esValida() {
        return monto < 1000;
    }

    public double calcularTasa() {
        double tasa;
        switch (tarjeta.getMarca()) {
            case "VISA":
                int lastTwoDigitsOfYear = LocalDate.now().getYear() % 100;
                tasa = lastTwoDigitsOfYear / (double) LocalDate.now().getMonthValue();
                break;
            case "NARA":
                tasa = LocalDate.now().getDayOfMonth() * 0.5;
                break;
            case "AMEX":
                tasa = LocalDate.now().getMonthValue() * 0.1;
                break;
            default:
                throw new IllegalArgumentException("Marca de tarjeta no corresponde con ninguna marca almacenada en base de datos");
        }
        return tasa;
    }
}

