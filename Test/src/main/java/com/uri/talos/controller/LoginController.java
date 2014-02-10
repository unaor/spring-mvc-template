package com.uri.talos.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import com.uri.talos.controller.form.LoginForm;
import com.uri.talos.controller.validator.LoginValidator;

@Controller
public class LoginController {
	
	
	@InitBinder("loginValidator")
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(new LoginValidator());
	}

	@RequestMapping("/login")
	public String renderLogin(Model model){
		LoginForm form =  new LoginForm();
		model.addAttribute("loginForm", form);
		return "login/loginScreen";
	}
	
	@RequestMapping(value ="/loginDo", method=RequestMethod.POST )
	private String authenticate(WebRequest request, Model model,@Valid @ModelAttribute("form") LoginForm form,BindingResult result){
		LoginValidator validator = new LoginValidator();
		validator.validate(form, result);
		if(result.hasErrors()){
			List<String> errors= new ArrayList<String>();
			for(ObjectError error : result.getAllErrors()){
				if(error.getCodes().toString()!=null){
					errors.add(error.getCodes()[3]);
					model.addAttribute("customErrors",errors );
				}
				
			}
			//return "redirect:/login";
		}
		
		//TODO: authenticate
		model.addAttribute("successMessage", "you are now logged in");
		model.addAttribute("loginForm", form);
		return "login/loginScreen";

	}
}
