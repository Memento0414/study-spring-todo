package org.edupoll.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class IndexController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@GetMapping("/")
	public String navigate(@SessionAttribute(required = false) String logonUser) {
		logger.debug("logonUser = " + logonUser);
		
		if(logonUser == null) {
			return "redirect:/auth";
		}else {
			return "redirect:/todos";
		}
	}
}
