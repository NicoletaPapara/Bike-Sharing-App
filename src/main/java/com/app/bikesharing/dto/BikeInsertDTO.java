package com.app.bikesharing.dto;

import com.app.bikesharing.model.BikeType;
import com.app.bikesharing.model.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BikeInsertDTO {

    private int ownerID;
    private BikeType bikeType;
    private Size size;
    private double price;

}
