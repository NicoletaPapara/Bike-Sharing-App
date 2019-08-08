package com.app.bikesharing.controller;

import com.app.bikesharing.model.User;
import com.app.bikesharing.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

//import com.app.bikesharing.model.UserDetails;

//import com.app.bikesharing.service.RegistrationService;

@Controller
public class RegistrationController {


    @Autowired//Autowired means inject bean called registrationService
    private RegistrationService registrationService;

    private User user = new User();

    @GetMapping(value = "/register")
    public ModelAndView register(Model model) {

        ModelAndView modelAndView = new ModelAndView();



        modelAndView.addObject("user", user);

        modelAndView.setViewName("register");//resources/template/register.html

        return modelAndView;
    }

    @PostMapping(value = "/register")
    public ModelAndView registerUser(@Valid User user, BindingResult bindingResult, ModelMap modelMap) {
        ModelAndView modelAndView = new ModelAndView();

        //Checking validations
        if (bindingResult.hasErrors()) {

            modelAndView.addObject("successMessage", "Registration unsuccessful. Please fill in all of the required fields.");

            //To show the bindingResult on the screen, add the bindingResult into the modelMap
            modelMap.addAttribute("bindingResult", bindingResult);
        } else if (registrationService.userIsRegistered(user)) {
            //if user is already registered don't save, send message

            modelAndView.addObject("successMessage", "User is already registered.");


        } else {
            //If there are no binding errors, save the new User.
            registrationService.saveUser(user);

            modelAndView.addObject("successMessage", "User has been successfully registered.");

        }


        modelAndView.addObject("user", new User());
        modelAndView.setViewName("register");
        return modelAndView;

    }


//    @GetMapping(value = "/register/userdetails")
//    public ModelAndView userDetails(Model model) {
//
//        ModelAndView modelAndView = new ModelAndView();
//
//
//
//        List<UserDetails> userDetails= user.getUserDetails();
//
//        modelAndView.addObject("userdetails", userDetails);
//
//        modelAndView.setViewName("userDetails");//resources/template/userdetails.html
//
//        return modelAndView;
//    }





//    @PostMapping(value = "/register/userdetails")
//    public ModelAndView registerUserDetails(@Valid User user, BindingResult bindingResult, ModelMap modelMap) {
//        ModelAndView modelAndView = new ModelAndView();
//
//        //Checking validations
//        if (bindingResult.hasErrors()) {
//
//            modelAndView.addObject("successMessage", "Registration unsuccessful. Please fill in all of the required fields.");
//
//            //To show the bindingResult on the screen, add the bindingResult into the modelMap
//            modelMap.addAttribute("bindingResult", bindingResult);
//        }  else {
//            //If there are no binding errors, save the new User.
//            registrationService.saveUser(user);
//
//            modelAndView.addObject("successMessage", "User details have been successfully registered.");
//
//        }
//
//
//        modelAndView.addObject("userdetails", new User().getUserDetails());
//        modelAndView.setViewName("userdetails");
//        return modelAndView;
//
//    }

    @GetMapping(value = "/home")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home"); // resources/template/home.html
        return modelAndView;
    }
    /*
    Show all registered users.
    By default RequestMapping generates a GET method.
    We can test the method by typing the value in
    the localhost8080 on our browser
     */

////    @RequestMapping("/registeredusers")
////    public List<RegistrationDTO> getAllUsers(){
////
////
////        return registrationService.getAllRegisteredUsers();
////
////    }
//
//
//    /**
//     * Show only one registered user based on the id
//     * Putting id into curly brackets means that it is a
//     *  variable
//     */
//
//    @RequestMapping("/registeredusers/{id}")
//    public User getOneRegisteredUser(@PathVariable int id){
//
//        return registrationService.findRegisteredUserById(id);
//    }
//
//    /*
//    Here we costumize the RequestMapping annotation to call a
//     POST method
//     */
//
//
//
//    @RequestMapping(method = RequestMethod.PUT, value="/registeredusers/{id}")
//    public void updateRegisteredUser(@RequestBody User user, @PathVariable int id) {
//
//        registrationService.updateRegisteredUser(id, user);
//
//    }
//
//    @RequestMapping(method = RequestMethod.DELETE, value="/registeredusers/{id}")
//    public void unregisterUser(@PathVariable int id) {
//
//        registrationService.unregisterUser(id);
//
//    }

}
