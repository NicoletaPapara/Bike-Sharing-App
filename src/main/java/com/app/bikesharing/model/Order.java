package com.app.bikesharing.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class Order {
    private Bike bike;
    private User owner;
    private User renter;
    private int id;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

}
