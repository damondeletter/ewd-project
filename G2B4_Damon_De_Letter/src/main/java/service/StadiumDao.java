package service;

import java.util.List;

import domain.Stadium;
import domain.WedstrijdTicket;

public interface StadiumDao extends GenerischeDao<Stadium> {

	public List<String> getStadiumList();
	public List<WedstrijdTicket> getWedstrijdTicketsByStadiumName(String name);
	
}
