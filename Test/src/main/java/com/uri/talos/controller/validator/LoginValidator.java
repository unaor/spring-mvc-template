package com.uri.talos.controller.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.uri.talos.controller.form.LoginForm;

public class LoginValidator implements Validator {

	@Override
	public boolean supports(Class clazz) {
		return LoginForm.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		LoginForm form  = (LoginForm)target;
		if(form.getUserName().isEmpty()){
			errors.rejectValue("userName", "user name cant be empty");
		}
		if(form.getPassword().isEmpty()){
			errors.rejectValue("password", "password cant be empty");
		}
		
	}

}
