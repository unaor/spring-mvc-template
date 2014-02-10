package com.uri.talos.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uri.talos.dao.PreferenceDao;
import com.uri.talos.domain.Preference;
import com.uri.talos.exception.DaoException;
@Repository
public class PreferenceDaoImpl implements PreferenceDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Preference> getAllPreferences() throws DaoException {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from Preference").list();
	}

	@Override
	public void addPreference(Preference preference) throws DaoException{
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(preference);

	}

	@Override
	public void deletePreference(Preference preference) throws DaoException{
		Session session = sessionFactory.getCurrentSession();
		session.delete(preference);

	}

}
