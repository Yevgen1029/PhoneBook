package com.yevgen.controller;

import com.yevgen.model.User;
import com.yevgen.model.UserRoles;
import com.yevgen.service.interfaces.UserService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

public class UserControllerTest {

    @Mock
    UserService userService;

    @InjectMocks
    UserController userController;

    @Spy
    ModelMap model;

    @Spy
    User user;

    @Spy
    List<UserRoles> userRolesList = new ArrayList<>();

    @Spy
    List<User> users = new ArrayList<>();

    @Mock
    BindingResult result;

    @BeforeClass
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        users.add(getUser());
    }

    @Test
    public void loginPage() {
        Assert.assertEquals(userController.loginPage("", "" ,model), "login");
        Assert.assertTrue(model.containsAttribute("error"));
        Assert.assertTrue(model.containsAttribute("msg"));
    }

    @Test
    public void registrationPage() {
        Assert.assertEquals(userController.registrationPage(model), "register");
        Assert.assertTrue(model.containsAttribute("user"));
        Assert.assertTrue(model.containsAttribute("checkPassword"));
    }

    @Test
    public void addUser() {
        Assert.assertEquals(userController.addUser(getUser(), result, getUser().getPassword(), model), "login");
        Assert.assertEquals(userController.addUser(getUser(), result, "", model), "register");
        Assert.assertNotNull(model.get("user"));
        Assert.assertTrue(model.containsAttribute("checkPassword"));
        verify(userService, atLeastOnce()).getUserByLogin(getUser().getLogin());
    }

    public User getUser() {
        User user = new User();
        user.setEnabled(true);
        user.setFio("SetFio");
        user.setLogin("Login");
        user.setPassword("Password");
        user.setUserRoles(new HashSet<>(userRolesList));

        UserRoles userRoles = new UserRoles();
        userRoles.setRole("ROLE_USER");
        userRoles.setUser(user);
        userRoles.setId(1L);

        userRolesList.add(userRoles);
        return user;
    }
}
