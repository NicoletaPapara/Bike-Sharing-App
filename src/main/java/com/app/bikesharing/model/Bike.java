package com.app.bikesharing.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Setter
@Getter
public class Bike {

    @Id
    @GeneratedValue
    private int id;
    private int userId;
    // Blob type file for image
    private byte[] image;
    private BikeType type;
    private Size size;
    private double price;
    private Availability availability;

}
