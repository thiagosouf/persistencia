package com.persistencia.modelaai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.persistencia.modelaai.model.Car;

public interface CarsRepository extends JpaRepository<Car, Long> {

}
