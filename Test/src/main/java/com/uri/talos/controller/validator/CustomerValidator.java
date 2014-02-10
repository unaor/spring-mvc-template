package com.uri.talos.controller.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.uri.talos.domain.Customer;

public class CustomerValidator implements Validator {
	
	@Override
	public boolean supports(Class clazz) {
		return Customer.class.equals(clazz);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		Customer customer  = (Customer)target;
		if(customer.getFirstName().isEmpty()){
			errors.rejectValue("firstName", "First Name cant be empty");
		}
		if(customer.getLastName().isEmpty()){
			errors.rejectValue("lastName", "Last Name cant be empty");
		}
		
		if (customer.getUserName().isEmpty()){
			errors.rejectValue("userName", "user name cant be empty");
		}
		
	}

}
