package com.springBoot.fifa;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

	
	@GetMapping("/")
	public String showHomePage() {
		return "redirect:/fifa";

	}
}