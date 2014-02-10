package com.uri.talos.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.uri.talos.dao.CustomerDao;
import com.uri.talos.domain.Customer;
import com.uri.talos.exception.DaoException;
import com.uri.talos.exception.TalosException;
import com.uri.talos.service.CustomerService;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true ,rollbackFor = Exception.class)
public class CustomerServiceImpl implements CustomerService {

	private static Logger log = Logger.getLogger(StoreServiceImpl.class);
	
	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public List<Customer> getAllCustomers() throws TalosException {
		log.debug("start - get customers");
		try {
			List<Customer> customers = customerDao.getAllCustomers();
			log.debug("end - get stores");
			return customers;
		} catch (DaoException e) {
			log.error("Error getting customers"+e);
			throw new TalosException("Service is not availiable please try again later");
		}
	}

	@Override
	public Customer getCustomerByUserName(String userName)
			throws TalosException {
		try {
			Customer customer  = customerDao.getCustomerByUserName(userName);
			return customer;
		} catch (DaoException e) {
			log.error("Error getting customer"+e);
			throw new TalosException("Service is not availiable please try again later");
		}
	}

	@Override
	public Customer getCustomerByEmail(String email) throws TalosException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(readOnly=false)
	public void addCustomer(Customer customer) throws TalosException {
		log.debug("start - add customer");
		try {
			customerDao.addCustomer(customer);
			log.debug("end - add customer");
		} catch (DaoException e) {
			log.error("Error adding customer"+e);
			throw new TalosException("Service is not availiable please try again later");
		}
		

	}

}
