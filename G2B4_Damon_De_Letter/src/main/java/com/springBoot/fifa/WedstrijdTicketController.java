package com.springBoot.fifa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import service.WedstrijdTicketDao;

@Controller
public class WedstrijdTicketController {

	@Autowired
	private WedstrijdTicketDao wedstrijdTdao;
	
	@GetMapping(value="/wedstrijdticket")
	public String listWedstrijdTicket(Model model) {
		model.addAttribute("wedstrijdTicketList", wedstrijdTdao.findAll());
		return "wedstrijdticket";
	}
	
}
