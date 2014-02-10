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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.uri.talos.controller.validator.StoreValidator;
import com.uri.talos.domain.Store;
import com.uri.talos.exception.TalosException;
import com.uri.talos.service.StoreService;

@Controller
public class StoreController {
	
	@Autowired
	StoreService storeService;
	
	@InitBinder("storeValidator")
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(new StoreValidator());
	}
	
	@RequestMapping("/store")
	public String storeIndex(RedirectAttributes redirectAttributes){
		List<Store> stores;
		try {
			stores = storeService.getStores();
			redirectAttributes. addAttribute("stores",stores);
			//model.addAttribute("stores", stores);
		} catch (TalosException e) {
			//model.addAttribute("message", e.getMessage());
			redirectAttributes.addFlashAttribute("message",e.getMessage());
		}
		
		return "store/store";
	}
	
	
	@RequestMapping("/store/add")
	public String addStore(Model model){
		Store store = new Store();
		model.addAttribute("store", store);
		
		return "store/addStore";
	}
	
	@RequestMapping(value ="/store/addStoreDo", method=RequestMethod.POST )
	public String addStore(WebRequest request/*, Model model*/,@Valid @ModelAttribute("store") Store store,
							BindingResult result,RedirectAttributes redirectAttributes){
		StoreValidator validator = new StoreValidator();
		validator.validate(store, result);
		if(result.hasErrors()){
			List<String> errors= new ArrayList<String>();
			for(ObjectError error : result.getAllErrors()){
				if(error.getCodes().toString()!=null){
					errors.add(error.getCodes()[3]);
					redirectAttributes.addFlashAttribute("customErrors",errors );
				}
				
			}
			redirectAttributes.addFlashAttribute("store", store);
			redirectAttributes.addFlashAttribute("customErrors", errors);
			return "store/addStore";
			//return new RedirectView("/store/addStore", true);
		} // passed validation
		try {
			storeService.addStore(store);
		} catch (TalosException e) {
			redirectAttributes.addFlashAttribute("message", e.getMessage());
			//return new RedirectView("/store/addStore", true);
			return "store/addStore";
		}
		//model.addAttribute("message", "Store added successfully");
		//return new RedirectView("/store", true);
		//redirectAttributes.addAttribute("foo", "hehehhe");
		redirectAttributes.addFlashAttribute("message", "Store added successfully");
		return "redirect:/store";
		//RedirectView redirectView = new RedirectView("/store",true);
		//redirectView.setExposeModelAttributes(false);
		//return redirectView;
		//return new RedirectView("/store", true).setExposeModelAttributes(false);
	}
}
