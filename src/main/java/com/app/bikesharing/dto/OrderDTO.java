package com.app.bikesharing.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class OrderDTO {
    private int bikeId;
    private int ownerId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

    public OrderDTO(){}

    public OrderDTO(int bikeId, Date startDate, Date endDate) {
        this.bikeId = bikeId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public void setBikeId(int bikeId) {
        this.bikeId = bikeId;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getBikeId() {
        return bikeId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }
}
