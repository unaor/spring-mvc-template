package com.uri.talos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {
	
	@RequestMapping("/")
	public String index(Model model){
		model.addAttribute("message", "Vamos Uri");
		return "index";
		
	}

}
