package com.strip.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Quick {
	
	
	
	@GetMapping({"/","/index"})
	public  String test(@RequestParam(value = "name",
	defaultValue = "Some",required =true) String name, Model model){
		model.addAttribute("name", name);
		return  "index";
		
	}

	
	
	

}
