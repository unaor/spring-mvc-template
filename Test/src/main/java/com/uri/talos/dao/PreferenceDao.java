package com.uri.talos.dao;

import java.util.List;

import com.uri.talos.domain.Preference;
import com.uri.talos.exception.DaoException;

public interface PreferenceDao {
	
	public List<Preference> getAllPreferences() throws DaoException;
	
	public void addPreference(Preference preference) throws DaoException;
	
	public void deletePreference(Preference preference) throws DaoException;

}
