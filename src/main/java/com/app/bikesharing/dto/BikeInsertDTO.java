package com.app.bikesharing.dto;

import com.app.bikesharing.model.BikeType;
import com.app.bikesharing.model.Size;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data

public class BikeInsertDTO {

    private int userId;
    private BikeType type;
    private Size size;
    private double price;
    private MultipartFile image;
}
