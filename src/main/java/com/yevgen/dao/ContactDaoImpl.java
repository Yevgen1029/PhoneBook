package com.yevgen.dao;

import com.yevgen.dao.interfaces.ContactDao;
import com.yevgen.model.Contact;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ContactDaoImpl extends AbstractDao<Contact> implements ContactDao{
    public List<Contact> getContactsByUserLogin(String login) {
        String hql = "from Contact as contact where contact.user.login = :login";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString("login", login);
        return query.list();
    }
}
