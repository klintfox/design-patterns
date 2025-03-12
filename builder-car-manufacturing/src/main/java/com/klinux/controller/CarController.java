package com.klinux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.klinux.model.Car;
import com.klinux.service.ICarService;

@RestController
public class CarController {

    @Autowired
    private ICarService carService;

    @GetMapping("/buildCar/{model}")
    public Car buildCar(@PathVariable String model) {
        return carService.buildCar(model);
    }
}