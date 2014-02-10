package com.uri.talos.controller.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.uri.talos.domain.Store;

public class StoreValidator  implements Validator{
	
	@Override
	public boolean supports(Class clazz) {
		return Store.class.equals(clazz);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		Store store  = (Store)target;
		if(store.getStoreName().isEmpty()){
			errors.rejectValue("storeName", "Store name  cant be empty");
		}
		if(store.getStoreNit().isEmpty()){
			errors.rejectValue("storeNit", "Nit cant be empty");
		}
		
	}

}
