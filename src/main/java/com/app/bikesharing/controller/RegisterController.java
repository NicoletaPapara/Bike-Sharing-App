package com.app.bikesharing.controller;

import com.app.bikesharing.model.User;
import com.app.bikesharing.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//RestController allows will return a JSON string for a possible web API
public class RegisterController {


    //Autowired means that this field needs dependency injection
    @Autowired
    private RegisterService registerService;


    /*
    Show all registered users.
    By default RequestMapping generates a GET method.
    We can test the method by typing the value in
    the localhost8080 on our browser
     */

    @RequestMapping("/registeredusers")
    public List<User> getAllUsers(){


        return registerService.getAllRegisteredUsers();

    }


    /**
     * Show only one registered user based on the id
     * Putting id into curly brackets means that it is a
     *  variable
     */

    @RequestMapping("/registeredusers/{id}")
    public User getOneRegisteredUser(@PathVariable int id){

        return registerService.getOneRegisteredUserById(id);
    }

    /*
    Here we costumize the RequestMapping annotation to call a
     POST method
     */

    @RequestMapping(method = RequestMethod.POST, value="/registeredusers")
    /**
     * Since the value /topics is used by default for the GET method,
     * you cannot use simply the Chrome browser to check whether the POST
     * method has been called.
     * For convenience, I use postman on Chrome to test the POST method
     *     In the registerNewMethod an annotation is placed in front
     *     of the parameter to tell
     *     the method to get the RequestBody
     */

    public void registerNewUser(@RequestBody User user) {

       registerService.registerNewUser(user);

    }

    @RequestMapping(method = RequestMethod.PUT, value="/registeredusers/{id}")
    public void updateRegisteredUser(@RequestBody User user, @PathVariable int id) {

        registerService.updateRegisteredUser(id, user);

    }

    @RequestMapping(method = RequestMethod.DELETE, value="/registeredusers/{id}")
    public void unregisterUser(@PathVariable int id) {

        registerService.unregisterUser(id);

    }

}
