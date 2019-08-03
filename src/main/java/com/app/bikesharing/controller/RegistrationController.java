package com.app.bikesharing.controller;

import com.app.bikesharing.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

//import com.app.bikesharing.service.RegistrationService;

@Controller(value = "/")
public class RegistrationController {


//    @Autowired//Autowired means inject bean called registrationService
//    private RegistrationService registrationService;

    @GetMapping(value = {"/register"})
    public ModelAndView register(Model model) {

        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("register");//resources/template/register.html
        return modelAndView;
    }

//    @GetMapping(value = "/home")
//    public ModelAndView home() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("home"); // resources/template/home.html
//        return modelAndView;
//    }

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
//    @RequestMapping(method = RequestMethod.POST, value="/registeredusers")
//    /**
//     * Since the value /topics is used by default for the GET method,
//     * you cannot use simply the Chrome browser to check whether the POST
//     * method has been called.
//     * For convenience, I use postman on Chrome to test the POST method
//     *     In the registerNewMethod an annotation is placed in front
//     *     of the parameter to tell
//     *     the method to get the RequestBody
//     */
//
//    public void registerNewUser(@RequestBody User user) {
//
//       registrationService.registerNewUser(user);
//
//    }
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
