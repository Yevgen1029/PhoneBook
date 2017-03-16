package com.yevgen.dao.interfaces;

import com.yevgen.model.Contact;

import java.util.List;

public interface ContactDao extends GenericDao<Contact> {
    List<Contact> getContactsByUserLogin(String login);
}
