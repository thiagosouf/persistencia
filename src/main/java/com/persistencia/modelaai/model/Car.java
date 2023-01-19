package com.persistencia.modelaai.model;

import com.persistencia.modelaai.dto.CarsDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor

public class Car {

    public Car(CarsDTO data) {
        this.modelo = data.modelo();
        this.valor = data.valor();
        this.fabricante = data.fabricante();
        this.dataFabricacao = data.dataFabricacao();
        this.anoModelo = data.anoModelo();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column(length = 20, nullable = false)
    private String modelo;

    @Column(length = 20, nullable = false)
    private String fabricante;

    @Column(length = 10, nullable = false)
    private String dataFabricacao;

    @Column(length = 10, nullable = false)
    private Double valor;

    @Column(length = 10, nullable = false)
    private Integer anoModelo;
}