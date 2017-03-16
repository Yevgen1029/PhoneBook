package com.yevgen.service;

import com.yevgen.dao.interfaces.ContactDao;
import com.yevgen.model.Contact;
import com.yevgen.service.interfaces.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {
    @Autowired
    ContactDao contactDao;

    public Contact create(Contact contact) {
        return contactDao.create(contact);
    }

    public Contact update(Contact contact) {
        return contactDao.update(contact);
    }

    public Contact read(Long contactId) {
        return contactDao.read(Contact.class, contactId);
    }

    public Contact delete(Contact contact) {
        return contactDao.delete(contact);
    }

    public List<Contact> getAllContacts(String login) {
        return contactDao.getContactsByUserLogin(login);
    }
}
