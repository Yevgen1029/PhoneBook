package com.yevgen.service;

import com.yevgen.dao.interfaces.UserDao;
import com.yevgen.model.User;
import com.yevgen.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    public User getUserByLogin(String login) {
        User user = userDao.getUserByLogin(User.class, login);
        return user;
    }

    public User createUser(User user) {
        User newUser = userDao.create(user);
        userDao.createStandartUserRole(user);
        return newUser;
    }

    public User updateUser(User user) {
        userDao.update(user);
        return user;
    }

    public User deleteUser(User user) {
        userDao.delete(user);
        return user;
    }
}
