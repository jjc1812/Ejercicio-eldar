package com.example.prueba.objetos;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class Tarjeta {
    @NotNull
    private String marca;
    @NotNull
    private String numero;
    @NotNull
    private String cardholder;
    @NotNull
    private LocalDate fechaVencimiento;

    public Tarjeta(String marca, String numero, String cardholder, LocalDate fechaVencimiento) {
        this.marca = marca;
        this.numero = numero;
        this.cardholder = cardholder;
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getMarca() {
        return marca;
    }

    public String getNumero() {
        return numero;
    }

    public String getCardholder() {
        return cardholder;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public boolean esValidaParaOperar() {
        return fechaVencimiento.isAfter(LocalDate.now());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Tarjeta tarjeta = (Tarjeta) obj;
        return numero.equals(tarjeta.numero);
    }
}

