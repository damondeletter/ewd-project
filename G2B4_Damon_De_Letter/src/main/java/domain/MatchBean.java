package domain;

import java.util.List;

import service.StadiumDao;

public class MatchBean{

	public List<WedstrijdTicket> getWedrijdenByStadium(String value, StadiumDao stadiumdao) {
		return stadiumdao.getWedstrijdTicketsByStadiumName(value);
	}
	

}
