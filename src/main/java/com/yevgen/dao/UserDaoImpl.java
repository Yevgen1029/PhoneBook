package com.yevgen.dao;

import com.yevgen.dao.interfaces.UserDao;
import com.yevgen.model.User;
import com.yevgen.model.UserRoles;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class UserDaoImpl extends AbstractDao<User> implements UserDao{
    public User getUserByLogin(Class<User> userClass, String login) {
        Session session = sessionFactory.getCurrentSession();
        User user = (User) session.get(userClass, login);
        session.flush();
        return user;
    }

    public UserRoles createStandartUserRole (User user) {
        UserRoles userRoles = new UserRoles();
        userRoles.setUser(user);
        userRoles.setRole("ROLE_USER");
        Session session = sessionFactory.getCurrentSession();
        session.save(userRoles);
        session.flush();
        return userRoles;
    }
}
