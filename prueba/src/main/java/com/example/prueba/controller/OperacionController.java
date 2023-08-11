package com.example.prueba.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.prueba.DTO.OperacionResponseDTO;
import com.example.prueba.objetos.Operacion;
import com.example.prueba.objetos.Tarjeta;

@RestController
public class OperacionController {

    @PostMapping("/procesamiento")
    public OperacionResponseDTO calcularTasa(@RequestBody @Valid Tarjeta tarjeta, @RequestParam String marca, @RequestParam double importe) {
        Operacion operacion = new Operacion(tarjeta, importe);

        if (!operacion.esValida()) {
            throw new IllegalArgumentException("El importe no es valido");
        }

        if (!tarjeta.esValidaParaOperar()) {
            throw new IllegalArgumentException("La tarjeta se encuentra vencida y no se puede operar");
        }

        double tasaCalculada = operacion.calcularTasa();

        OperacionResponseDTO operacionResponseDTO = new OperacionResponseDTO();
        operacionResponseDTO.setTasa(tasaCalculada);
        operacionResponseDTO.setImporte(importe);
        operacionResponseDTO.setMarca(marca);
        
        return operacionResponseDTO;
    }
}

