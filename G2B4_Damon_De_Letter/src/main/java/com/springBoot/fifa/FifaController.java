package com.springBoot.fifa;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import domain.AanschafTicket;
import domain.ExpertBean;
import domain.MatchBean;
import domain.StadiumBean;
import domain.WedstrijdTicket;
import service.VoetbalServiceImpl;
import validator.AanschafTicketValidator;

@Controller
@RequestMapping("/fifa")
public class FifaController {
	
	VoetbalServiceImpl vsi = new VoetbalServiceImpl();
	
	@Autowired
	ExpertBean expertBean;
	MatchCommand matchCommand = new MatchCommand();
	
	@Autowired
	private AanschafTicketValidator aanschafTicketValidator;
	
	//bijhouden van ticket als error terugleidt naar pagina
	WedstrijdTicket huidigeWedstrijdGekozen;
	
	@ModelAttribute("stadiumList") public List<String> populateStadia() {
		 return(new StadiumBean()).getStadiumList(); }

	
	@GetMapping
	public String showHomePage(Model model) {
		model.addAttribute("matchCommand", new MatchCommand());
		return "startScreen";
	}
	
	@PostMapping
	public String onSubmit(@ModelAttribute MatchCommand matchCommand, Model model) {
		model.addAttribute("stadium", matchCommand.getStadiumSelected());
		List<WedstrijdTicket> matchObjects = expertBean.getExpert(matchCommand.getStadiumSelected(), vsi);
		List<List<String>> matches = new ArrayList<>();
		for(WedstrijdTicket match : matchObjects) {
			List<String> matchData = new ArrayList<>();
			matchData.add(match.getWedstrijd().getId());
			matchData.add(String.format("%s - %s", match.getWedstrijd().getLanden()[0], match.getWedstrijd().getLanden()[1]));
			matchData.add(String.format("%d nov", match.getWedstrijd().getDag()));
			matchData.add(String.format("%d:00",match.getWedstrijd().getUur()));
			matchData.add(String.format("%d", match.getTickets()));
			matches.add(matchData);
			
		}
		model.addAttribute("listMatch",matches);
		model.addAttribute("listStadia", new MatchBean().getExpert(matchCommand.getStadiumSelected(), vsi));
		return "overviewMatches";
	}
	
	@GetMapping("/{id}")
	public String showTicketForm(RedirectAttributes redirectAttributes, @PathVariable(value = "id") String id, Model model) {
		huidigeWedstrijdGekozen = vsi.getWedstrijd(id);
		
		model.addAttribute("stadium", matchCommand.getStadiumSelected());
		model.addAttribute("aanschafTicket",new AanschafTicket());
		model.addAttribute("wedstrijdnaam", huidigeWedstrijdGekozen.getWedstrijd().toString());
		model.addAttribute("tickets", huidigeWedstrijdGekozen.getTickets());
		System.out.println(huidigeWedstrijdGekozen.getTickets());
		
		if(huidigeWedstrijdGekozen.uitverkocht()) {
			redirectAttributes.addFlashAttribute("uitverkochteMatch", huidigeWedstrijdGekozen);
			return "redirect:/fifa?uitverkocht=true";
		}
		return "buyTickets";	
	}
	
	@PostMapping("/{id}")
	public String onSubmit(@Valid AanschafTicket aanschafTicket, BindingResult result, RedirectAttributes redirectAttributes, @PathVariable(value="id") String id) {
		aanschafTicketValidator.validate(aanschafTicket, result);
		if(result.hasErrors()) {
			return "buyTickets";
		}
		
		int aanschaftickets = aanschafTicket.getTickets();
		int ticketsAantal = vsi.ticketsBestellen(id, aanschaftickets);
		redirectAttributes.addFlashAttribute("ticketsAantal", ticketsAantal);
		return String.format("%s%d", "redirect:/fifa?verkocht=", ticketsAantal);
	}
	

	
}