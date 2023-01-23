package com.persistencia.modelaai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    }

    @PutMapping("/{id}")
    public void updateCars(@PathVariable Long id, @RequestBody CarsDTO req) {
        repository.findById(id).map(cars -> {
            cars.setModelo(req.modelo());
            cars.setFabricante(req.fabricante());
            cars.setDataFabricacao(req.dataFabricacao());
            cars.setValor(req.valor());
            cars.setAnoModelo(req.anoModelo());
            return repository.save(cars);
        });
    }

    @DeleteMapping("/{id}")
    public void deleteCars(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
