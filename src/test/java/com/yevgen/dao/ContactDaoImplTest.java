package com.yevgen.dao;

import org.dbunit.dataset.CompositeDataSet;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.Test;

@Repository
@Transactional
public class ContactDaoImplTest extends AbstractDaoImplTest{

	protected IDataSet getDataSet() throws Exception {
	  IDataSet[] datasets = new IDataSet[] {
			  new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("Users.xml")),
			  new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("UserRoles.xml")),
			  new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("Contacts.xml"))
	  };
	  return new CompositeDataSet(datasets);
	}

    @Test
    public void create() {

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
    public void getContactsByUserLogin() {

    }
}
