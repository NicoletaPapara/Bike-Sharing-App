package com.app.bikesharing.dto;

import com.app.bikesharing.model.BikeType;
import com.app.bikesharing.model.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BikeInsertDTO {

    private int userId;
    private BikeType type;
    private Size size;
    private double price;
    private MultipartFile image;
}
