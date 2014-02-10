package com.uri.talos.dao;

import java.util.List;

import com.uri.talos.domain.Store;
import com.uri.talos.exception.DaoException;

public interface StoreDao {
	
	public Store getStoreByNit(String nit) throws DaoException;
	
	public void addStore(Store store) throws DaoException;
	
	public List<Store> getStores() throws DaoException;
	
	public void deleteStore(Store store) throws DaoException;

}
