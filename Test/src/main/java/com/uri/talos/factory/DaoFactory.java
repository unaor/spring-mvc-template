package com.uri.talos.factory;

import com.uri.talos.dao.CustomerDao;
import com.uri.talos.dao.PreferenceDao;
import com.uri.talos.dao.StoreDao;

public class DaoFactory {
	//TODO: configure autowire
	//@Autowired
	private static CustomerDao customerDao;
	//@Autowired
	private static StoreDao storeDao;
	//@Autowired
	private static PreferenceDao preferenceDao;
	
	
	public static CustomerDao getCustomerDao() {
		return customerDao;
	}
	public void setCustomerDao(CustomerDao customerDao) {
		DaoFactory.customerDao = customerDao;
	}
	public static StoreDao getStoreDao() {
		return storeDao;
	}
	public void setStoreDao(StoreDao storeDao) {
		DaoFactory.storeDao = storeDao;
	}
	public static PreferenceDao getPreferenceDao() {
		return preferenceDao;
	}
	public void setPreferenceDao(PreferenceDao preferenceDao) {
		DaoFactory.preferenceDao = preferenceDao;
	}
	
}
