package com.yevgen.service.interfaces;

import com.yevgen.model.User;

public interface UserService {
    User getUserByLogin(String email);

    User createUser(User user);

    User updateUser(User user);

    User deleteUser(User user);
}
