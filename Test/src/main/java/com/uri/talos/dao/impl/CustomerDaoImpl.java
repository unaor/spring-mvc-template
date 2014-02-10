package com.uri.talos.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uri.talos.dao.CustomerDao;
import com.uri.talos.domain.Customer;
import com.uri.talos.exception.DaoException;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getAllCustomers() throws DaoException{
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from Customer").list();
	}

	@Override
	public Customer getCustomerByUserName(String userName) throws DaoException {
		Session session = sessionFactory.getCurrentSession();
		return (Customer)session.createQuery("from Customer where userName=userName").uniqueResult();
	}

	@Override
	public Customer getCustomerByEmail(String email) throws DaoException {
		Session session = sessionFactory.getCurrentSession();
		return (Customer)session.createQuery("from Customer where email=email").uniqueResult();
	}

	@Override
	public void addCustomer(Customer customer) throws DaoException{
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(customer);

	}

	@Override
	public void deleteCustomer(Customer customer) throws DaoException{
		Session session = sessionFactory.getCurrentSession();
		session.delete(customer);
		
	}

}
