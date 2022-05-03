package domain;

import java.util.List;

import service.VoetbalServiceImpl;

public interface ExpertBean {
	
	public List<WedstrijdTicket> getExpert(String value, VoetbalServiceImpl voetbal);

}
