package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({@NamedQuery(name="stadium.getStadiumName", query = "SELECT s FROM Stadium s where s.name = :name")})
public class Stadium implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@OneToMany
	private List<WedstrijdTicket> wedstrijdTickets;
	
	private String name;
	
	protected Stadium() {}
	
	public Stadium(String name) {
		wedstrijdTickets = new ArrayList<>();
		setName(name);
	}

	public List<WedstrijdTicket> getWedstrijdTickets() {
		return wedstrijdTickets;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setWedstrijdTickets(List<WedstrijdTicket> wedstrijdTickets) {
		this.wedstrijdTickets = wedstrijdTickets;
	}
	

}
