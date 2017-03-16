package com.yevgen.service;

import com.yevgen.dao.interfaces.ContactDao;
import com.yevgen.model.Contact;
import com.yevgen.model.User;
import com.yevgen.model.UserRoles;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;


public class ContactServiceImplTest {

    @Mock
    ContactDao contactDao;

    @InjectMocks
    ContactServiceImpl contactService;

    @Spy
    Contact contact;

    @Spy
    List<Contact> contactList = new ArrayList<>();

    @Spy
    List<UserRoles> userRolesList = new ArrayList<>();

    @Spy
    User user;

    @BeforeClass

    public void setUp() {
        MockitoAnnotations.initMocks(this);
        user = getUser();
        contact = getContact();
        contactList.add(getContact());
    }

    @Test
    public void create() {
        when(contactDao.create(any(Contact.class))).thenReturn(contact);
        contactService.create(contact);
        Assert.assertEquals(contactService.create(contact), contact);
        verify(contactDao, atLeastOnce()).create(any(Contact.class));
    }

    @Test
    public void update() {
        when(contactDao.update(any(Contact.class))).thenReturn(contact);
        contactService.update(contact);
        Assert.assertEquals(contactService.update(contact), contact);
        verify(contactDao, atLeastOnce()).update(any(Contact.class));
    }

    @Test
    public void read() {
        when(contactDao.read(anyObject(), anyLong())).thenReturn(contact);
        contactService.read(contact.getContactId());
        Assert.assertEquals(contactDao.read(anyObject(), anyLong()), contact);
        verify(contactDao, atLeastOnce()).read(anyObject(), anyLong());
    }

    @Test
    public void delete() {
        when(contactDao.delete(any(Contact.class))).thenReturn(contact);
        contactService.delete(contact);
        Assert.assertEquals(contactService.delete(contact), contact);
        verify(contactDao, atLeastOnce()).delete(any(Contact.class));
    }

    @Test
    public void getAllContacts() {
        when(contactDao.getContactsByUserLogin(anyString())).thenReturn(contactList);
        Assert.assertEquals(contactService.getAllContacts(anyString()), contactList);
    }


    public User getUser() {
        User user = new User();
        user.setEnabled(true);
        user.setLogin(null);
        user.setPassword("Password");
        user.setFio("SetFio");
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
        c1.setPatronymic("Patronymic1");
        c1.setSecondName("SecondName1");
        c1.setMobilePhoneNumber("+380(12)1234567");
        return c1;
    }
}
