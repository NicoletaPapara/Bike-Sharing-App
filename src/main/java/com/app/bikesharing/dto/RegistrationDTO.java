package com.app.bikesharing.dto;

import com.app.bikesharing.model.UserDetails;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
public class RegistrationDTO {
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
