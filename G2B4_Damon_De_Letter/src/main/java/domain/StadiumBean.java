package domain;

import java.util.List;

import service.VoetbalServiceImpl;

public class StadiumBean {

	private final List<String> stadiumList;
	
	public StadiumBean() {
		stadiumList = new VoetbalServiceImpl().getStadiumList();
	}
	public List<String> getStadiumList() {
		return stadiumList;
	}
}
