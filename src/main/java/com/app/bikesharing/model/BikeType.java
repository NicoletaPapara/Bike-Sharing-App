package com.app.bikesharing.model;

public enum BikeType {
    MOUNTAIN("MTB"),
    ROAD("road"),
    ELECTRIC("electric");

    private String description;

    BikeType(String description){
        this.description = description;
    }

    public String getDescription(){
        return this.description;
    }
}
