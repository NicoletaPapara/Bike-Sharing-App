package com.app.bikesharing.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Setter
@Getter
@ToString
public class Bike {

    @Id
    @GeneratedValue
    private int id;
    private int userId;
    // Blob type file for images
    @Lob
    @NotNull(message = "upload images")
    private byte[] image;
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

    public Bike(){

    }
  }
