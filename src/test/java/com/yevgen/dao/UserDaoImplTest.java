package com.yevgen.dao;

import com.yevgen.dao.interfaces.UserDao;
import com.yevgen.model.User;
import com.yevgen.model.UserRoles;
import org.dbunit.dataset.CompositeDataSet;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class UserDaoImplTest {


    @Spy
    List<User> userList = new ArrayList<>();

    @Spy
    User user;

    @Spy
    List<UserRoles> userRolesList = new ArrayList<>();

//    @BeforeClass
//    public void setUp() {
//        MockitoAnnotations.initMocks(this);
//        user = getUser();
//        userList.add(getUser());
//        userRolesList.add(getRole());
//    }

    @Autowired
    UserDao userDao;

    protected IDataSet getDataSet() throws Exception {
        IDataSet[] datasets = new IDataSet[]{
                new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("Users.xml")),
                new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("UserRoles.xml")),
                new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("Contacts.xml"))
        };
        return new CompositeDataSet(datasets);
    }

    @Test
    public void create() {
//        System.out.println(getUser().getLogin());
//        userDao.create(getUser());
//        Assert.assertEquals(userDao.getUserByLogin(User.class, user.getLogin()), user);
    }

    @Test
    public void update() {

    }

    @Test
    public void delete() {

    }

    @Test
    public void read() {

    }

    @Test
    public void getUserByLogin() {

    }

    @Test
    public void createStandartUserRole() {

    }


    public User getUser() {
        User user = new User();
        user.setLogin("Login");
        user.setEnabled(true);
        user.setFio("SetFio");
        user.setPassword("Password");
//        user.setUserRoles(new HashSet<>(userRolesList));

        return user;
    }

    public UserRoles getRole() {
        UserRoles userRoles = new UserRoles();
        userRoles.setRole("ROLE_USER");
        userRoles.setId(1L);
        userRoles.setUser(user);

        return userRoles;
    }
}
