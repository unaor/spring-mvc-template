package com.uri.talos.unit.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.uri.talos.domain.Store;
import com.uri.talos.exception.TalosException;
import com.uri.talos.service.StoreService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/testContext.xml")
@TransactionConfiguration(defaultRollback=true)
@Transactional
public class StoreServiceTest {
	
	@Autowired
	StoreService storeService;
	
	@Before
	public void insertStore() throws TalosException{
		Store store = new Store();
		store.setStoreName("ToysRUS");
		store.setStoreNit("9999");
		storeService.addStore(store);
	}
	
	@After
	public void cleanDataBase() throws  TalosException{
		List<Store> stores = storeService.getStores();
		if(stores.size()>0){
			for (Store store : stores){
				storeService.deleteStore(store);
			}
		}
	}
	
	@Test
	public void getStoreByNit() throws TalosException{
		Store store = storeService.getStoreByNit("9999");
		assertEquals(store.getStoreName(), "ToysRUS");
	}

}
