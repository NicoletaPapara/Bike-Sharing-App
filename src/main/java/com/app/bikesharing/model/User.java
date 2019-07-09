package com.app.bikesharing.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    private int id;
    private int age;
    private String firstName;
    private String lastName;
    private String cnp;
    private UserDetails userDetails;
    private double rating;
    private String email;
    private String password;


}
