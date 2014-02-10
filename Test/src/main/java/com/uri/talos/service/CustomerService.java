package com.uri.talos.service;

import java.util.List;

import com.uri.talos.domain.Customer;
import com.uri.talos.exception.TalosException;

public interface CustomerService {
	
	public List<Customer> getAllCustomers() throws TalosException;
	
	public Customer getCustomerByUserName(String userName) throws TalosException;
	
	public Customer getCustomerByEmail(String email) throws TalosException;
	
	public void addCustomer(Customer customer) throws TalosException;
	

}
