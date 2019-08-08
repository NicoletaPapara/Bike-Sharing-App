package com.app.bikesharing.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Setter
@Getter
@Entity
@Table(name = "order_history")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int bikeId;
    private int userId;
    @NotNull
    private LocalDate startDate;
    @NotNull
    private LocalDate endDate;
}
