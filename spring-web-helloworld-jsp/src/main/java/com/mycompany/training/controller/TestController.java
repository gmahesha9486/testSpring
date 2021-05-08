package com.mycompany.training.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Controller
@RequestMapping("/")
public class TestController {

	private static final Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@RequestMapping(method = RequestMethod.GET)
    public String sayHello(ModelMap model) {
		
		 //logger.info("123 this is a info message");
	     //logger.warn("123 this is a warn message");
	     //logger.error("123 this is a error message");
	      
        model.addAttribute("greeting", "Hello World from Spring 5 MVC");
        return "welcome";
    }
	
	@RequestMapping("/hello")
	public String testMessage(ModelMap model) {
		
		logger.info("123 this is a info message");
	    logger.warn("123 this is a warn message");
	    logger.error("123 this is a error message");
		
		System.out.println("Am i printing ? =============================");
		return "welcome";
	}
	
	@RequestMapping("/test")
	public String testMethod(ModelMap model) {
		
		System.out.println("This is Test Method");
		
		String name="Mahesh";
		String password="password123";
		
		model.put("name", name);
        model.put("password", password);
        
		return "test";
	}
	
}
