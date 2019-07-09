package com.app.bikesharing.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Bike {
    private int id;
    private int image;
    private BikeType type;
    private Size size;
    private double price;
    private Availability availability;

}
