package service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import domain.Stadium;
import domain.Wedstrijd;
import domain.WedstrijdTicket;

public class DatabankToevoegen implements CommandLineRunner {

	@Autowired
	private StadiumDao stadiumJpa;
	@Autowired
	private WedstrijdTicketDao wedstrijdticketdaoJpa;
	@Autowired
	GenerischeDao<Wedstrijd> generischeDaoWedstrijd;
	
	@Override
	public void run(String... args) throws Exception {
		List<WedstrijdTicket> wedstrijdtickets1, wedstrijdtickets2;
		
		Stadium stadium1 = new Stadium("Al Bayt Stadium");
		Stadium stadium2 = new Stadium("Al Thumama Stadium");
		Wedstrijd wedstrijd1 = new Wedstrijd(1, new ArrayList<>(Arrays.asList("België", "Canada")),"november", 26, 21);
		Wedstrijd wedstrijd2 = new Wedstrijd(2,  new ArrayList<>(Arrays.asList("Brazilië", "Zwitserland")),"november", 27, 18);
		Wedstrijd wedstrijd3 = new Wedstrijd(3, new ArrayList<>(Arrays.asList("Marroko", "Kroatië")),"november", 28, 15);
		Wedstrijd wedstrijd4 = new Wedstrijd(4,new ArrayList<>(Arrays.asList("Spanje", "Duitsland")),"november", 28, 18);
		Wedstrijd wedstrijd5 = new Wedstrijd(5,new ArrayList<>(Arrays.asList("Frankrijk", "Denemarken")),"november", 30, 15);
		Wedstrijd wedstrijd6 = new Wedstrijd(6,new ArrayList<>(Arrays.asList("Argentinië", "Mexico")),"november", 30, 18);
		Wedstrijd wedstrijd7 = new Wedstrijd(7,new ArrayList<>(Arrays.asList("Engeland", "USA")),"december", 1, 18);
		Wedstrijd wedstrijd8 = new Wedstrijd(8, new ArrayList<>(Arrays.asList("Nederland", "Qatar")),"december", 1, 21);
		
		List<Wedstrijd> wedstrijden = Arrays.asList(wedstrijd1, wedstrijd2, wedstrijd3, wedstrijd4, wedstrijd5, wedstrijd6,wedstrijd7, wedstrijd8);
		generischeDaoWedstrijd.insertAll(wedstrijden);

		WedstrijdTicket wedstrijdticket1 = new WedstrijdTicket(wedstrijd1, 35);
		WedstrijdTicket wedstrijdticket2 =  new WedstrijdTicket(wedstrijd2, 21);
		WedstrijdTicket wedstrijdticket3 =  new WedstrijdTicket(wedstrijd3, 5);
		WedstrijdTicket wedstrijdticket4 = new WedstrijdTicket(wedstrijd4, 95);
		WedstrijdTicket wedstrijdticket5 = new WedstrijdTicket(wedstrijd5, 45);
		WedstrijdTicket wedstrijdticket6 = new WedstrijdTicket(wedstrijd6, 10);
		WedstrijdTicket wedstrijdticket7 = new WedstrijdTicket(wedstrijd7, 22);
		WedstrijdTicket wedstrijdticket8 = new WedstrijdTicket(wedstrijd8, 16);
		
		wedstrijdtickets1 = Arrays.asList(wedstrijdticket1, wedstrijdticket2, wedstrijdticket3, wedstrijdticket4, wedstrijdticket5);
		wedstrijdtickets2 = Arrays.asList(wedstrijdticket6, wedstrijdticket7,wedstrijdticket8);
		
		wedstrijdticketdaoJpa.insertAll(wedstrijdtickets1);
		wedstrijdticketdaoJpa.insertAll(wedstrijdtickets2);
		stadium1.setWedstrijdTickets(wedstrijdtickets1);
		stadium2.setWedstrijdTickets(wedstrijdtickets2);
		
		stadiumJpa.insert(stadium1);
		stadiumJpa.insert(stadium2);
	}
}
