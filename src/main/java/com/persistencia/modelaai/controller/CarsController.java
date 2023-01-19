package com.persistencia.modelaai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.persistencia.modelaai.dto.CarsDTO;
import com.persistencia.modelaai.model.Car;
import com.persistencia.modelaai.repository.CarsRepository;

@RestController
@RequestMapping("/")

public class CarsController {

    @Autowired
    private CarsRepository repository;

    @GetMapping
    public List<Car> listAll() {
        return repository.findAll();
    }

    @PostMapping
    public void createCars(@RequestBody CarsDTO req) {
        repository.save(new Car(req));
        // System.out.println("ID =>" + req.modelo());
        // System.out.println("MODELO => " + req.modelo());
        // System.out.println("FABRICANTE => " + req.fabricante());
        // System.out.println("DATA FABRICACAO => " + req.dataFabricacao());
        // System.out.println("VALOR => " + req.valor());
        // System.out.println("ANO => " + req.anoModelo());
    }
}
