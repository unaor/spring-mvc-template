package com.uri.talos.service;

import java.util.List;

import com.uri.talos.domain.Store;
import com.uri.talos.exception.TalosException;

public interface StoreService {
	
	public List<Store> getStores() throws TalosException;
	
	public void addStore(Store store) throws TalosException;
	
	public Store getStoreByNit(String nit) throws TalosException;
	
	public void deleteStore(Store store) throws TalosException;

}
