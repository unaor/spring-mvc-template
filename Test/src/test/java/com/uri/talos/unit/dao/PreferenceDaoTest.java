package com.uri.talos.unit.dao;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import com.uri.talos.dao.PreferenceDao;
import com.uri.talos.domain.Customer;
import com.uri.talos.domain.Preference;
import com.uri.talos.exception.DaoException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/testContext.xml")
@TransactionConfiguration(defaultRollback=true)
@Transactional
public class PreferenceDaoTest {
	
	@Autowired
	CustomerDao customerDao;
	@Autowired 
	PreferenceDao preferenceDao;
	
	@Before
	public void insertCustomer() throws DaoException{
		Preference firstPreference = new Preference();
		firstPreference.setPreferenceName("Promociones Confama");
		Preference secondPreference = new Preference();
		secondPreference.setPreferenceName("Promociones Visa");
		preferenceDao.addPreference(firstPreference);
		preferenceDao.addPreference(secondPreference);
	}
	
	@After
	public void cleanDataBase() throws DaoException{
		List<Preference> preferences = preferenceDao.getAllPreferences();
		if(preferences.size()>0){
			for (Preference preference : preferences){
				preferenceDao.deletePreference(preference);
			}
		}
	}
	
	@Test
	public void getClientPreferences() throws DaoException{
		Customer uri = new Customer();
		List<Preference> preferences = preferenceDao.getAllPreferences();
		assertEquals(preferences.size(), 2);
		Set<Preference> customerPreferences = new HashSet<Preference>();
		customerPreferences.add(preferences.get(0));
		uri.setPreferences(customerPreferences);
		uri.setUserName("urinaor");
		customerDao.addCustomer(uri);
		Customer dbCustomer = customerDao.getCustomerByUserName("urinaor");
		assertEquals(dbCustomer.getPreferences().size(), 1);
		for (Preference preference : dbCustomer.getPreferences()){
			assertEquals(preference.getPreferenceName(),"Promociones Confama");
		}
		
	}
	

}
