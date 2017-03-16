package com.yevgen.dao;

import com.yevgen.dao.interfaces.GenericDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class AbstractDao<T> implements GenericDao<T> {
    @Autowired
    SessionFactory sessionFactory;

    public T create(T t) {
        Session session = sessionFactory.getCurrentSession();
        session.save(t);
        session.flush();
        return t;
    }

    public T read(Class<T> tClass, Long id) {
        Session session = sessionFactory.getCurrentSession();
        T t = (T) session.get(tClass, id);
        session.flush();
        return t;
    }

    public T update(T t) {
        Session session = sessionFactory.getCurrentSession();
        session.update(t);
        session.flush();
        return t;
    }

    public T delete(T t) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(t);
        session.flush();
        return t;
    }

    public List<T> readAll(Class<T> tClass) {
        return sessionFactory.getCurrentSession().createCriteria(tClass).list();
    }

}
