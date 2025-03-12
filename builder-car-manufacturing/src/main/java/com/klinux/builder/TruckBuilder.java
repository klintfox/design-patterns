package com.klinux.builder;

import com.klinux.model.Car;

public class TruckBuilder {

    public Car build() {
        return Car.builder()
                  .model("Truck")
                  .engine("5.0L V8")
                  .wheels("20-inch Alloy")
                  .doors("4 Doors")
                  .interior("Fabric")
                  .build();
    }
}