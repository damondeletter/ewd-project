package domain;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//Een wedstrijd
@Entity
public class Wedstrijd {
	//attributen
	@Id
    private long id; //unieke sleutel
	
    private ArrayList<String> landen; //2 landen van de wedstrijd
    private int dag; //dag van de wedstrijd
    private int uur; //uur van de wedstrijd
    private String maand;

    protected Wedstrijd() {
    }

    public Wedstrijd(long id, ArrayList<String> landen,String maand, int dag, int uur) {
        this.id = id;
        this.landen = landen;
        this.maand = maand;
        this.dag = dag;
        this.uur = uur;
    }

    public long getId() {
        return id;
    }

    public ArrayList<String> getLanden() {
        return landen;
    }
    public String getMaand() {
    	return maand;
    }
    
    public int getDag() {
        return dag;
    }

    public int getUur() {
        return uur;
    }
    
    @Override
    public String toString()
    {
        return String.format("%s vs %s op %d %s", landen.get(0), landen.get(1), dag, maand); 
    }
}