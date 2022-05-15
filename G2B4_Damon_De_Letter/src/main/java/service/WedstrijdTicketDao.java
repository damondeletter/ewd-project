
package service;

import java.util.List;

import domain.WedstrijdTicket;

public interface WedstrijdTicketDao extends GenerischeDao<WedstrijdTicket>{
	//extends GenerischeDao<WedstrijdTicket>

	public List<WedstrijdTicket> findAll();
	//public List<WedstrijdTicket> getWedstrijdTicketById(String id);
	
	public int saveTickets(String id, int tickets);


}
