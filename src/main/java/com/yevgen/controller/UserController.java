package com.yevgen.controller;

import com.yevgen.model.User;
import com.yevgen.service.interfaces.UserService;
import com.yevgen.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    UserService userService;


    @RequestMapping(value = {"/", "/login"} , method = RequestMethod.GET)
    public String loginPage(@RequestParam(value = "error", required = false) String error,
                            @RequestParam(value = "logout", required = false) String logout, ModelMap model) {
        if (error != null) {
            error = "Wrong login or password";
            model.addAttribute("error", error);
        }

        if (logout != null) {
            logout = "You have been logged out successfully";
            model.addAttribute("msg", logout);
        }

        return "login";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registrationPage(ModelMap model) {
        model.addAttribute("user", new User());
        model.addAttribute("checkPassword", new String());
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String addUser(@Valid User user, BindingResult result,
                          @ModelAttribute("checkPassword") String checkPassword,
                          ModelMap model) {

        if (result.hasErrors()) return "register";

        model.addAttribute("user", new User());
        model.addAttribute("checkPassword", new String());
        if (userService.getUserByLogin(user.getLogin()) != null) {                                                      //check for uniqueness of inputted email
            model.addAttribute("loginError", Constants.LOGIN_ALREADY_USED_ERROR);
            return "register";
        }
        if (!user.getPassword().equals(checkPassword)) {                                                                //password confirmation
            model.addAttribute("confirmPasswordError", Constants.PASSWORD_CONFIRMATION_ERROR);
            return "register";
        }
            model.addAttribute("addedUser", userService.createUser(user));
        return "login";
    }
}
