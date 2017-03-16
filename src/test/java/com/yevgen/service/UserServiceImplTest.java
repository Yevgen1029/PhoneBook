package com.yevgen.service;

import com.yevgen.dao.interfaces.UserDao;
import com.yevgen.model.User;
import com.yevgen.model.UserRoles;
import junit.framework.Assert;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.mockito.Mockito.*;

public class UserServiceImplTest {

    @Mock
    UserDao userDao;

    @InjectMocks
    UserServiceImpl userService;

    @Spy
    List<User> userList = new ArrayList<>();

    @Spy
    User user;

    @Spy
    List<UserRoles> userRolesList = new ArrayList<>();

    @BeforeClass
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        user = getUser();
        userList.add(getUser());
        userRolesList.add(getRole());
    }

    @Test
    public void getUserByLogin() {
        when(userDao.getUserByLogin(anyObject(), anyString())).thenReturn(user);
        Assert.assertEquals(userService.getUserByLogin(user.getLogin()), user);
    }

    @Test
    public void createUser() {
        when(userDao.create(any(User.class))).thenReturn(user);
        userService.createUser(user);
        Assert.assertEquals(userService.createUser(user), user);
        verify(userDao, atLeastOnce()).create(any(User.class));
    }

    @Test
    public void updateUser() {
        when(userDao.update(any(User.class))).thenReturn(user);
        userService.updateUser(user);
        verify(userDao, atLeastOnce()).update(any(User.class));
    }

    @Test
    public void deleteUser() {
        when(userDao.delete(any(User.class))).thenReturn(user);
        userService.deleteUser(user);
        verify(userDao, atLeastOnce()).delete(any(User.class));
    }

    public User getUser() {
        User user = new User();
        user.setEnabled(true);
        user.setLogin("Login");
        user.setFio("SetFio");
        user.setPassword("Password");
        user.setUserRoles(new HashSet<>(userRolesList));

        return user;
    }

    public UserRoles getRole() {
        UserRoles userRoles = new UserRoles();
        userRoles.setRole("ROLE_USER");
        userRoles.setUser(user);
        userRoles.setId(1L);

        return userRoles;
    }
}
