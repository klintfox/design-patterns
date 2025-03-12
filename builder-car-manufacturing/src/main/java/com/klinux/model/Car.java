package com.klinux.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Car {
    private String model;
    private String engine;
    private String wheels;
    private String doors;
    private String interior;
}