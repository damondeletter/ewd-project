package service;

import domain.WedstrijdTicket;

public class WedstrijdTicketsDaoJPA extends GenerischeDaoJPA<WedstrijdTicket> implements WedstrijdTicketDao {

	public WedstrijdTicketsDaoJPA(Class<WedstrijdTicket> type) {
		super(type);
		
	}

	@Override
	public int saveTickets(String id, int tickets) {
		
		WedstrijdTicket wedstrijdticketje = get(Long.parseLong(id));
		wedstrijdticketje.ticketsKopen(tickets);
		update(wedstrijdticketje);
		return tickets;
	}

}
