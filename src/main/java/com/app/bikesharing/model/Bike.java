package com.app.bikesharing.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

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
    private int ownerId;
    @Enumerated(EnumType.STRING)
    private BikeType type;
    @Enumerated(EnumType.STRING)
    private Size size;
    private double price;

    public Bike(int id, BikeType type, Size size) {
        this.id = id;
        this.type = type;
        this.size = size;
    }
  }
