package domain;

import java.util.List;

import service.VoetbalServiceImpl;

public class MatchBean implements ExpertBean{

	@Override
	public List<WedstrijdTicket> getExpert(String value, VoetbalServiceImpl voetbal) {
		
		return voetbal.getWedstrijdenByStadium(value);
	}
	

}
