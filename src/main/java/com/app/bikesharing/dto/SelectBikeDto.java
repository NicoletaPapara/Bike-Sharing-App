package com.app.bikesharing.dto;

import com.app.bikesharing.model.BikeType;
import com.app.bikesharing.model.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SelectBikeDto {
    private int id;
    private BikeType type;
    private Size size;
    private Double price;
}
