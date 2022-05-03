package validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import domain.AanschafTicket;

public class AanschafTicketValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return AanschafTicket.class.isAssignableFrom(clazz);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		AanschafTicket aanschafticket = (AanschafTicket) target;
		if(aanschafticket.getVoetbalCode1() != null && aanschafticket.getVoetbalCode2() != null) {
			if(aanschafticket.getVoetbalCode1() > aanschafticket.getVoetbalCode2()) {
				errors.rejectValue("voetbalCode1", "validation.aanschafticket.voetbalCode1.error", "voetbalcode1 must be smaller than voetbalcode2");
				errors.rejectValue("voetbalCode2", "validation.aanschafticket.voetbalCode2.error", "voetbalcode2 must be bigger than voetbalcode1");
			}
			
			
		}
		
		
	}

}
