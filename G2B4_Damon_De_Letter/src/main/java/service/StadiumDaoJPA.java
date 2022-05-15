package service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.transaction.annotation.Transactional;

import domain.Stadium;
import domain.WedstrijdTicket;

public class StadiumDaoJPA extends GenerischeDaoJPA<Stadium> implements StadiumDao{

	public StadiumDaoJPA(Class<Stadium> type) {
		super(type);
		
	}

	@Override
	public List<String> getStadiumList() {
		return findAll().stream().map(stadium -> stadium.getName()).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	@Override
	public List<WedstrijdTicket> getWedstrijdTicketsByStadiumName(String name) {
		return em.createNamedQuery("stadium.getStadiumName", Stadium.class).setParameter("name", name).getSingleResult().getWedstrijdTickets();
	}
	
	

}
