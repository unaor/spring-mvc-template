package com.uri.talos.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.uri.talos.controller.validator.CustomerValidator;
import com.uri.talos.controller.validator.StoreValidator;
import com.uri.talos.domain.Customer;
import com.uri.talos.exception.TalosException;
import com.uri.talos.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@InitBinder("customerValidator")
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(new StoreValidator());
	}
	
	@RequestMapping("/customer")
	public String storeIndex(Model model){
		List<Customer> customers;
		try {
			customers = customerService.getAllCustomers();
			model.addAttribute("customers", customers);
		} catch (TalosException e) {
			model.addAttribute("message", e.getMessage());
		}
		
		return "customer/customer";
	}
	
	@RequestMapping("/customer/add")
	public String addStore(Model model){
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		
		return "customer/addCustomer";
	}
	
	@RequestMapping(value ="/customer/addCustomerDo", method=RequestMethod.POST )
	public String addCustomer(WebRequest request, Model model,@Valid @ModelAttribute("customer") Customer customer,BindingResult result){
		CustomerValidator validator = new CustomerValidator();
		validator.validate(customer, result);
		if(result.hasErrors()){
			List<String> errors= new ArrayList<String>();
			for(ObjectError error : result.getAllErrors()){
				if(error.getCodes().toString()!=null){
					errors.add(error.getCodes()[3]);
					model.addAttribute("customErrors",errors );
				}
				
			}
			model.addAttribute("customer", customer);
			model.addAttribute("customErrors", errors);
			return "customer/addCustomer";
		} // passed validation 
		try {
			//Todo:fix bug ingetCustomerByUserName
			/*Customer dbCustomer = customerService.getCustomerByUserName(customer.getUserName());
			if(dbCustomer!=null){
				model.addAttribute("message", "this user name is already occupied");
				return "customer/addCustomer";
			}*/ 
			customerService.addCustomer(customer);
		} catch (TalosException e) {
			model.addAttribute("message", e.getMessage());
			return "customer/addCustomer";
		}
		model.addAttribute("message", "Customer added successfully");
		
		return "redirect:/customer";
	}

}
