package com.klinux.builder;

import com.klinux.model.Car;

public class SUVBuilder {

    public Car build() {
        return Car.builder()
                  .model("SUV")
                  .engine("3.5L V6")
                  .wheels("18-inch Alloy")
                  .doors("5 Doors")
                  .interior("Premium Leather")
                  .build();
    }
}