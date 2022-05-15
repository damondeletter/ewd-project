package domain;

import java.util.List;

import service.StadiumDao;

public class StadiumBean {

	private final List<String> stadiumList;
	
	public StadiumBean(StadiumDao stadiumdao) {
		stadiumList = stadiumdao.getStadiumList();
	}
	public List<String> getStadiumList() {
		return stadiumList;
	}
}
