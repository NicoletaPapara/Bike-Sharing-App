package com.app.bikesharing.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/***
 * The model class is what needs to be mapped to a database.
 * We need to tell spring boot to map the instances of the topic class to a DB
 * Each field in the topic class is actually a column in the DB. We add
 * the annotation @Entity to the class and each instance becomes a row in the DB
 */
@Getter
@Setter
@Entity//The annotation makes a table out of this class
@Table(name = "user")
public class User {

    @Id//maps User id with DB table ID
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "status")
    private String status;

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id"))
//    private Set<Role> roles;


//    private int age;
//
//    private String cnp;
//
//
//    //private UserDetails userDetails;
//
//    private double rating;


}
