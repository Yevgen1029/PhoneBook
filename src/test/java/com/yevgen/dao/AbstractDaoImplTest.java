package com.yevgen.dao;

import com.yevgen.configuration.HibernateTestConfiguration;
import org.dbunit.dataset.IDataSet;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import javax.sql.DataSource;

@ContextConfiguration(classes = { HibernateTestConfiguration.class })
public abstract class AbstractDaoImplTest {
    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    DataSource dataSource;

//    @BeforeMethod
//    public void setUp() throws Exception {
//        IDatabaseConnection dbConn = new DatabaseDataSourceConnection(
//                dataSource);
//        DatabaseOperation.CLEAN_INSERT.execute(dbConn, getDataSet());
//    }

    protected abstract IDataSet getDataSet() throws Exception;


}
