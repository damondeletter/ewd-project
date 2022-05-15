package com.springBoot.fifa;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import domain.Wedstrijd;
import service.GenerischeDao;

@RestController
@RequestMapping(value="fifaDetail")
public class FifaRestController {
	
	@Autowired
	GenerischeDao<Wedstrijd> generischeWedstrijd;
	
	@GetMapping(value="/{id}")
	public List<String> getWedstrijdLand(@PathVariable("id") long id) {
		return generischeWedstrijd.get(id).getLanden();
	}
	
	//extra rest
	// ---------------
	
	//op basis van dag van de wedstrijd
	@GetMapping(value="/dag/{dag}")
	public List<Wedstrijd> getWedstrijdDag(@PathVariable("dag") int dag) {
		return generischeWedstrijd.findAll().stream().filter(wedstrijd -> wedstrijd.getDag() == dag).collect(Collectors.toList());
		
	}
	
	//alle wedstrijden weergeven
	@GetMapping(value="/wedstrijden")
	public List<Wedstrijd> getAllWedstrijden() {
		return generischeWedstrijd.findAll();
	}
	

}
