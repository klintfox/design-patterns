package com.klinux.service;

import org.springframework.stereotype.Service;

import com.klinux.builder.SUVBuilder;
import com.klinux.builder.SedanBuilder;
import com.klinux.builder.TruckBuilder;
import com.klinux.model.Car;

@Service
public class CarService implements ICarService{

    public Car buildCar(String model) {
        switch (model.toLowerCase()) {
            case "sedan":
                return new SedanBuilder().build();
            case "suv":
                return new SUVBuilder().build();
            case "truck":
                return new TruckBuilder().build();
            default:
                throw new IllegalArgumentException("Invalid car model");
        }
    }
}