package com.app.bikesharing.service;

import com.app.bikesharing.model.Bike;
import com.app.bikesharing.model.User;
import com.app.bikesharing.model.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service//@Service spring annotation makes sure that the RegisterService is instanciated only once for all autowired field
public class RegisterService {
    private User user;
    private Bike bike;
    private List<User> users=new ArrayList<>();
    private String email = "E-mail";

    {
        register("mama@mia.com");
    }
    
    public void register(String email) {

        //Validate here: if email exists then
        // send message Please Choose another email
        //else continue with the glow

        User user = new User();

        user.setEmail(email);

        String password = "Password";
        user.setPassword(password);


        int id = 1;
        user.setId(id);

        int age = 18;
        user.setAge(age);

        String firstName = "First Name";
        user.setFirstName(firstName);


        String lastName = "Last Name";
        user.setLastName("Last Name");

        String cnp = "1111cnp";
        user.setCnp(cnp);

        //By default we hardcode the initial rating to 5
        //and it will change
        double rating = 5;
        user.setRating(rating);

        //Details of the userDetails object we create
        int idOfUserDetails = 11;
        String phoneNo = "phone:0078344";
        int streetNo = 1;
        String streetName = "Street name";
        String city = "City Name";
        String county = "County Name";
        int zip = 111111;

        UserDetails userDetails = UserDetails.builder()
                .id(idOfUserDetails)
                .phoneNo(phoneNo)
                .streetNo(streetNo)
                .streetName(streetName)
                .city(city)
                .county(county)
                .zip(zip)
                .build();

        user.setUserDetails(userDetails);

        users.add(user);


    }


    public void registerNewUser(User user) {

        users.add(user);
    }

    public void updateRegisteredUser(int id, User user) {

        for(int i=0; i<users.size(); i++){
            if(users.get(i).getId()==id){
                users.set(i, user);
            }
        }
    }

    public void unregisterUser(int id) {
        //Validate if email correct
        //Validate if password maps email

        users.removeIf(user -> user.getId()==id);
    }

    public User getOneRegisteredUserById(int id) {
        //Validate to see if id is there. maybe use
        // Optional isPresent

        return users.stream()
                .filter(user -> user.getId() == id)
                .findFirst().get();
    }

    public List<User> getAllRegisteredUsers() {
        return users;
    }

}
