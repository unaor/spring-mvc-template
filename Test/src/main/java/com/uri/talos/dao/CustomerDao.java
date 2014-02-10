package com.uri.talos.dao;

import java.util.List;

import com.uri.talos.domain.Customer;
import com.uri.talos.exception.DaoException;

public interface CustomerDao {
	
	public List<Customer> getAllCustomers() throws DaoException;
	
	public Customer getCustomerByUserName(String userName) throws DaoException;
	
	public Customer getCustomerByEmail(String email) throws DaoException;
	
	public void addCustomer(Customer customer) throws DaoException;
	
	public void deleteCustomer(Customer customer) throws DaoException;

}
