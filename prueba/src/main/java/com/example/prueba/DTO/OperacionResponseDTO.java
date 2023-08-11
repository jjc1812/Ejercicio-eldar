package com.example.prueba.DTO;

public class OperacionResponseDTO {
    private String marca;
    private double tasa;
    private double importe;

    public OperacionResponseDTO() {
    }

    public OperacionResponseDTO(String marca, double tasa, double importe) {
        this.marca = marca;
        this.tasa = tasa;
        this.importe = importe;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getTasa() {
        return tasa;
    }

    public void setTasa(double tasa) {
        this.tasa = tasa;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }
}
