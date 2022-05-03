package domain;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

public class AanschafTicket {
	@NotEmpty(message= "{validation.empty}")
	@Email(message="{validation.invalidEmail}")
	private String email;
	
	@NotNull(message="{validation.empty}")
	@DecimalMin(value="1",message="{validation.ticketsTeKlein.message}")
	@DecimalMax(value="25", message="{validation.ticketsTeGroot.message}")
	@NumberFormat(style=Style.NUMBER)
	private Integer tickets = 1;
	
	@NotNull(message="{validation.empty}")
	@NumberFormat(style=Style.NUMBER)
	private Integer voetbalCode1 = 10, voetbalCode2 = 20;
	
	public String getEmail() {
		return email;
	}
	
	public Integer getTickets() {
		return tickets;
	}
	
	public Integer getVoetbalCode1() {
		return voetbalCode1;
	}
	
	public Integer getVoetbalCode2() {
		return voetbalCode2;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setTickets(Integer tickets) {
		this.tickets = tickets;
	}
	
	public void setVoetbalCode1(Integer voetbalCode1) {
		this.voetbalCode1 = voetbalCode1;
	}
	
	public void setVoetbalCode2(Integer voetbalCode2) {
		this.voetbalCode2 = voetbalCode2;
	}
	
	

}
