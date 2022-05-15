package service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import domain.Stadium;
import domain.WedstrijdTicket;

public class VoetbalServiceImpl implements VoetbalService{
	
	//zonder databank
	
	/*
	 * private ArrayList<String> landen1 = new ArrayList<>(); private
	 * ArrayList<String> landen2 = new ArrayList<>(); private ArrayList<String>
	 * landen3 = new ArrayList<>(); private ArrayList<String> landen4 = new
	 * ArrayList<>(); private ArrayList<String> landen5 = new ArrayList<>(); private
	 * ArrayList<String> landen6 = new ArrayList<>(); private ArrayList<String>
	 * landen7 = new ArrayList<>(); private ArrayList<String> landen8 = new
	 * ArrayList<>();
	 */
	
	/*
	 * private List<String> stadiumList = new ArrayList<>();
	 * //mapWedstrijdenByStadium, per stadium, een lijst van wedstrijden private
	 * final Map<String, List<WedstrijdTicket>> mapWedstrijdenByStadium = new
	 * HashMap<>(); //mapWedstrijdById, per id een wedstrijdTicket private final
	 * Map<String, WedstrijdTicket> mapWedstrijdById = new HashMap<>();
	 */
	
	//met databank
	@Autowired
	private StadiumDao stadiumdaoJPAdinges;
	
	@Autowired
	private GenerischeDao<WedstrijdTicket> wedstrijdJPA;
	
	private List<Stadium> stadiumlijst = new ArrayList<>();
    
    public VoetbalServiceImpl() {
    	stadiumlijst = stadiumdaoJPAdinges.findAll();
    	
        //zonder databank
		/*
		 * stadiumList = new ArrayList<>(Arrays.asList(new String[]{"Al Bayt Stadium",
		 * "Al Thumama Stadium"}));
		 * 
		 * landen1.add("België"); landen1.add("Canada"); mapWedstrijdById.put("1", new
		 * WedstrijdTicket(1, new Wedstrijd("1", landen1, 26, 21), 35,
		 * "Al Bayt Stadium")); landen2.add("Brazilië"); landen2.add("Zwitserland");
		 * mapWedstrijdById.put("2", new WedstrijdTicket(2, new Wedstrijd("2", landen2,
		 * 27, 18), 21, "Al Bayt Stadium")); landen3.add("Marroko");
		 * landen3.add("Kroatië"); mapWedstrijdById.put("3", new WedstrijdTicket(3, new
		 * Wedstrijd("3", landen3, 28, 15), 5, "Al Bayt Stadium"));
		 * landen4.add("Spanje"); landen4.add("Duitsland"); mapWedstrijdById.put("4",
		 * new WedstrijdTicket(4, new Wedstrijd("4", landen4, 28, 18), 95,
		 * "Al Thumama Stadium")); landen5.add("Frankrijk"); landen5.add("Denemarken");
		 * mapWedstrijdById.put("5", new WedstrijdTicket(5, new Wedstrijd("5", landen5,
		 * 30, 15), 45, "Al Thumama Stadium")); landen6.add("Argentinië");
		 * landen6.add("Mexico"); mapWedstrijdById.put("6", new WedstrijdTicket(6, new
		 * Wedstrijd("6", landen6, 30, 18), 10, "Al Bayt Stadium"));
		 * landen7.add("Engeland"); landen7.add("USA"); mapWedstrijdById.put("7", new
		 * WedstrijdTicket(7, new Wedstrijd("7", landen7, 31, 18), 22,
		 * "Al Bayt Stadium")); landen8.add("Nederland"); landen8.add("Qatar");
		 * mapWedstrijdById.put("8", new WedstrijdTicket(8, new Wedstrijd("8", landen8,
		 * 31, 21), 16, "Al Thumama Stadium"));
		 * 
		 * mapWedstrijdenByStadium.put(stadiumList.get(0), new
		 * ArrayList<>(Arrays.asList(new WedstrijdTicket[]{ mapWedstrijdById.get("1"),
		 * mapWedstrijdById.get("2"), mapWedstrijdById.get("3"),
		 * mapWedstrijdById.get("6"), mapWedstrijdById.get("7") })));
		 * 
		 * mapWedstrijdenByStadium.put(stadiumList.get(1), new
		 * ArrayList<>(Arrays.asList(new WedstrijdTicket[]{ mapWedstrijdById.get("4"),
		 * mapWedstrijdById.get("5"), mapWedstrijdById.get("8") })));
		 */
}

	
    //zonder databank
/*
 * public List<String> getStadiumList() { return stadiumList; }
 * 
 * //geeft de lijst "tickets per wedstrijden" terug volgens stadium public
 * List<WedstrijdTicket> getWedstrijdenByStadium(String stadium) { return
 * mapWedstrijdenByStadium.get(stadium); }
 * 
 * //geeft aantal tickets voor een wedstrijd terug volgens id public
 * WedstrijdTicket getWedstrijd(String id) { return mapWedstrijdById.get(id); }
 * public int ticketsBestellen(String id, int teBestellen) { WedstrijdTicket
 * wedstrijdTicket = mapWedstrijdById.get(id); return
 * wedstrijdTicket.ticketsKopen(teBestellen); }
 */
    
    //met databank
    @Override
	public List<String> getStadiumList() {
		return stadiumlijst.stream().map(stadium -> stadium.getName()).collect(Collectors.toList());
	}

	@Override
	public List<WedstrijdTicket> getWedstrijdenByStadium(String stadium) {
		return stadiumdaoJPAdinges.getWedstrijdTicketsByStadiumName(stadium);
	}

	@Override
	public WedstrijdTicket getWedstrijd(String id) {
		return wedstrijdJPA.get(Long.parseLong(id));
	}

	@Override
	public int ticketsBestellen(String id, int aantaltickets) {
		WedstrijdTicket wedstrijdTicket = getWedstrijd(id);
		wedstrijdTicket.ticketsKopen(aantaltickets);
		wedstrijdJPA.update(wedstrijdTicket);
		return wedstrijdTicket.getTickets();
	}

    
}
