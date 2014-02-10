package com.uri.talos.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.uri.talos.dao.StoreDao;
import com.uri.talos.domain.Store;
import com.uri.talos.exception.DaoException;
import com.uri.talos.exception.TalosException;
import com.uri.talos.service.StoreService;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true ,rollbackFor = Exception.class)
public class StoreServiceImpl implements StoreService {
	
	@Autowired
	private StoreDao storeDao;
	
	private static Logger log = Logger.getLogger(StoreServiceImpl.class);

	@Override
	public List<Store> getStores() throws TalosException {
		log.debug("start - get stores");
		try {
			List<Store> stores  = storeDao.getStores();
			log.debug("end - get stores");
			return stores;
		} catch (DaoException e) {
			log.error("Error getting stores"+e);
			throw new TalosException("Service is not availiable please try again later");
		}
	}

	@Override
	@Transactional(readOnly=false)
	public void addStore(Store store) throws TalosException {
		log.debug("start - add stores with NIT "+store.getStoreNit());
		try {
			storeDao.addStore(store);
			log.debug("end - add stores");
		} catch (DaoException e) {
			log.error("Error adding store"+e);
			throw new TalosException("Service is not availiable please try again later");
		}

	}

	@Override
	public Store getStoreByNit(String nit) throws TalosException {
		log.debug("start - get store with NIT "+nit);
		Store store;
		try {
			store = storeDao.getStoreByNit(nit);
			log.debug("end - get store with NIT "+nit);
			return store;
		} catch (DaoException e) {
			log.error("Error getting store by nit"+e);
			throw new TalosException("Service is not availiable please try again later");
		}
		
	}

	@Override
	@Transactional(readOnly=false)
	public void deleteStore(Store store) throws TalosException {
		log.debug("start - deleete store with NIT "+store.getStoreNit());
		try {
			storeDao.deleteStore(store);
		} catch (DaoException e) {
			log.error("Error deleteing store"+e);
			throw new TalosException("Service is not availiable please try again later");
		}
		
	}

}
