package com.app.bikesharing.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Set;


@Getter
@Setter

/***
 * The model class is what needs to be mapped to a database.
 * We need to tell spring boot to map the instances of the topic class to a DB
 * Each field in the topic class is actually a column in the DB. We add
 * the annotation @Entity to the class and each instance becomes a row in the DB
 */

@Entity//The annotation makes a table out of this class
@Table(name="user")
public class User {


    @Id//maps User id with DB table ID
    @GeneratedValue //(strategy = GenerationType.IDENTITY)//we want MySQL to generate the id. If the GenerationType is not specified we get a server error
    @Column(name="user_id")
    private int id;

    @NotNull(message= "First name cannot be omitted.")//Validation constraints annotation
    @Column(name= "first_name")//Mapping to DB
    private String firstName;

    @NotNull(message= "Last name cannot be omitted.")
    @Column(name = "last_name")
    private String lastName;

    @NotNull(message= "Email cannot be omitted.")
    @Email(message = "Invalid email.")
    @Column(name = "email")
    private String email;

    @NotNull(message= "User details cannot be omitted.")
    @Column(name = "userdetails")
    private String userdetails;

    @NotNull(message= "Password cannot be omitted.")
    @Length(min=4, message = "Minimum length of password is FOUR characters.")
    @Column(name = "password")
    private String password;

    @Column(name = "status")
    private String status;

    @Column(name = "rating")
    public int rating;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="user_role", joinColumns=@JoinColumn(name="user_id"),
            inverseJoinColumns =@JoinColumn(name= "role_id"))
    private Set<Role> roles;


}
