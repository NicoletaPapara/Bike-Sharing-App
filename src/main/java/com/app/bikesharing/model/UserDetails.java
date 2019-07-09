package com.app.bikesharing.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDetails {
    //Oare trebuie id pentru salvare in DB
    private int id;
    private String phoneNo;
    private int streetNo;
    private String streetName;
    private String city;
    private String county;
    private int zip;

}