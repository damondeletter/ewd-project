package domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class WedstrijdTicket implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	@OneToOne
	private Wedstrijd wedstrijd; 

    private int tickets; //aantal tickets beschikbaar

    public WedstrijdTicket(Wedstrijd wedstrijd, int tickets) {
        this.wedstrijd = wedstrijd;
        this.tickets = tickets;
    }
    protected WedstrijdTicket() {}
    public int getTickets() {
        return tickets;
    }
    
    public Wedstrijd getWedstrijd() {
        return wedstrijd;
    }
    
    //We willen 'aantal' tickets kopen
    public int ticketsKopen(int aantal) {
        if (aantal <= 0) {
            return -1;
        }
        
        //Nog voldoende tickets
        if (tickets >= aantal) {
            tickets -= aantal;
            return aantal;
        }

        //Niet meer voldoende tickets
        int gekocht = tickets;
        tickets = 0;
        return gekocht;
    }

    public boolean uitverkocht() {
        return tickets == 0;
    }
}
