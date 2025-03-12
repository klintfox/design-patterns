package com.klinux.builder;

import com.klinux.model.Car;

public class SedanBuilder {

    public Car build() {
        return Car.builder()
                  .model("Sedan")
                  .engine("2.0L V4")
                  .wheels("17-inch Alloy")
                  .doors("4 Doors")
                  .interior("Leather")
                  .build();
    }
}