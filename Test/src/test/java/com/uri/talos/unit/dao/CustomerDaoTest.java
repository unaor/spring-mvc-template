package com.uri.talos.unit.dao;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.uri.talos.dao.CustomerDao;
import com.uri.talos.domain.Customer;
import com.uri.talos.exception.DaoException;
import com.uri.talos.factory.DaoFactory;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/testContext.xml")
@TransactionConfiguration(defaultRollback=true)
@Transactional
public class CustomerDaoTest {
	
	@Autowired
	CustomerDao customerDao;
	
	@Before
	public void insertCustomer() throws DaoException{
		Customer uri = new Customer();
		uri.setUserName("urinaor");
		uri.setBirthDate(new Date());
		uri.setFirstName("uri");
		uri.setLastName("naor");
		uri.setLastName("naor");
		uri.setEmail("uri@naor.com");
		customerDao.addCustomer(uri);
	}
	
	@Test
	public void checkSession(){
		assertNotNull(customerDao);
	}
	
	@Test
	public void getAllCustomers()throws DaoException{
		List<Customer> customers = customerDao.getAllCustomers();
		assertEquals(1, customers.size());
	}
	
	@Test 
	public void getCustomerByUserName() throws DaoException{
	Customer uri  = customerDao.getCustomerByUserName("urinaor");
	assertEquals(uri.getFirstName(), "uri");
	Customer nonExistingCustomer  = customerDao.getCustomerByUserName("hghgh");
	assertNotNull(nonExistingCustomer);
	}
	
	
	@After
	public void cleanDataBase() throws DaoException{
		List<Customer> customers = customerDao.getAllCustomers();
		if(customers.size()>0){
			for (Customer customer : customers){
				customerDao.deleteCustomer(customer);
			}
		}
	}
}
