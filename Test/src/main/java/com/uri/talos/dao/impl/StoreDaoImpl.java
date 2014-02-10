package com.uri.talos.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uri.talos.dao.StoreDao;
import com.uri.talos.domain.Store;
import com.uri.talos.exception.DaoException;

@Repository
public class StoreDaoImpl implements StoreDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Store getStoreByNit(String storeNit) throws DaoException {
		Session session = sessionFactory.getCurrentSession();
		return (Store)session.createQuery("from Store where storeNit=storeNit").uniqueResult();
	}

	@Override
	public void addStore(Store store) throws DaoException {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(store);

	}

	@Override
	public List<Store> getStores() throws DaoException {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from Store").list();
	}

	@Override
	public void deleteStore(Store store) throws DaoException {
		Session session = sessionFactory.getCurrentSession();
		session.delete(store);
		
	}

}
