package com.yevgen.controller;

import com.yevgen.model.Contact;
import com.yevgen.model.User;
import com.yevgen.model.UserRoles;
import com.yevgen.service.interfaces.ContactService;
import com.yevgen.service.interfaces.UserService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.mockito.Mockito.when;

public class ContactsControllerTest {

    @Mock
    UserService userService;

    @Mock
    ContactService contactService;

    @InjectMocks
    ContactsController contactsController;

    @Spy
    ModelMap model;

    @Spy
    List<Contact> contactList = new ArrayList<>();

    @Spy
    List<UserRoles> userRolesList = new ArrayList<>();

    @Spy
    User user;

    @Mock
    BindingResult result;

    @BeforeClass
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        user = getUser();
        contactList.add(getContact());
    }

    @Test
    public void getContacts() {
        when(contactService.getAllContacts(getUser().getLogin())).thenReturn(contactList);
//        Assert.assertEquals(contactsController.getContacts(model), "contacts");
//        Assert.assertTrue(model.containsAttribute("contact"));
//        Assert.assertEquals(model.get("contactList"), contactList);
//        verify(contactService,atLeastOnce()).getAllContacts(getUser().getLogin());
    }

    @Test
    public void addContacts() {
//        Assert.assertEquals(contactsController.addContact(getContact(), model), "contacts");
//        Assert.assertNotNull(model.get("contact"));
//        Assert.assertNotNull(model.asMap().get("checkPassword"));
//        Assert.assertNotNull(model.asMap().get("modalDisplay"));
    }

    @Test
    public void updatePage() {
//        Assert.assertEquals(contactsController.updatePage(1L, model), "update");
//        Assert.assertTrue(model.containsAttribute("editContact"));
    }

    @Test
    public void updateContact() {
//        Assert.assertEquals(contactsController.updateContact(getContact(), model), "contacts");
//        Assert.assertNotNull(model.asMap().get("contact"));
//        Assert.assertNotNull(model.asMap().get("checkPassword"));
//        Assert.assertNotNull(model.asMap().get("modalDisplay"));
    }

    @Test
    public void deleteContact() {
//        Assert.assertEquals(contactsController.deleteContact(1L, model), "contacts");
//        Assert.assertNotNull(model.asMap().get("contact"));
//        Assert.assertNotNull(model.asMap().get("modalDisplay"));
//        Assert.assertNotNull(model.asMap().get("contactList"));
    }

    public User getUser() {
        User user = new User();
        user.setEnabled(true);
        user.setLogin(null);
        user.setFio("SetFio");
        user.setPassword("Password");
        user.setUserRoles(new HashSet<>(userRolesList));

        UserRoles userRoles = new UserRoles();
        userRoles.setRole("ROLE_USER");
        userRoles.setUser(user);
        userRoles.setId(1L);

        userRolesList.add(userRoles);
        return user;
    }

    public Contact getContact() {
        Contact c1 = new Contact();
        c1.setUser(getUser());
        c1.setContactId(1L);
        c1.setFirstName("FirstName1");
        c1.setSecondName("SecondName1");
        c1.setPatronymic("Patronymic1");
        c1.setMobilePhoneNumber("+380(12)1234567");
        return c1;
    }


}
