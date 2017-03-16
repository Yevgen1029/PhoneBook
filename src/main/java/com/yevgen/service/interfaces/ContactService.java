package com.yevgen.service.interfaces;

import com.yevgen.model.Contact;

import java.util.List;

public interface ContactService {
    Contact create(Contact contact);

    Contact update(Contact contact);

    Contact read(Long contactId);

    Contact delete(Contact contact);

    List<Contact> getAllContacts(String login);
}
