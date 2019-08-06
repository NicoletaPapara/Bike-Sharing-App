package com.app.bikesharing.model;

public enum Size {
    CHILD("child"),
    FEMALE("female"),
    MALE("male");

    private String description;

    Size(String description) {
        this.description = description;
    }

    public String getDescription(){
        return this.description;
    }
}
