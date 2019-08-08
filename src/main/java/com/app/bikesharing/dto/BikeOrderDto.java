package com.app.bikesharing.dto;

import com.app.bikesharing.model.BikeType;
import com.app.bikesharing.model.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class BikeOrderDto {
    private BikeType type;
    private Size size;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

    public BikeOrderDto(BikeType type, Size size, Date startDate, Date endDate) {
        this.type = type;
        this.size = size;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public BikeOrderDto() {

    }

    public BikeType getType() {
        return type;
    }

    public Size getSize() {
        return size;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setType(BikeType type) {
        this.type = type;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
