package com.app.bikesharing.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Getter
@Setter

/***
 * The model class is what needs to be mapped to a database.
 * We need to tell spring boot to map the instances of the topic class to a DB
 * Each field in the topic class is actually a column in the DB. We add
 * the annotation @Entity to the class and each instance becomes a row in the DB
 */

@Entity
public class User {

    @Id//maps User id with DB table ID
    private int id;

    private int age;
    private String firstName;
    private String lastName;
    private String cnp;

    @OneToOne// Each user maps to exactly one userDetailsObject
    private UserDetails userDetails;

    private double rating;
    private String email;
    private String password;


}
