package com.yevgen.dao.interfaces;

import com.yevgen.model.User;
import com.yevgen.model.UserRoles;

public interface UserDao extends GenericDao<User> {
    User getUserByLogin(Class<User> userClass, String string);
    UserRoles createStandartUserRole(User user);
}
