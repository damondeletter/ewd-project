package com.springBoot.fifa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import domain.MatchBean;
import domain.Stadium;
import domain.Wedstrijd;
import domain.WedstrijdTicket;
import service.DatabankToevoegen;
import service.GenerischeDao;
import service.GenerischeDaoJPA;
import service.StadiumDao;
import service.StadiumDaoJPA;
import service.WedstrijdTicketDao;
import service.WedstrijdTicketsDaoJPA;
import validator.AanschafTicketValidator;

//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
//MOET WEGGEHAALD WORDEN --> DE EXCLUDE
@SpringBootApplication
//@EntityScan(basePackages = "")
public class Application implements WebMvcConfigurer{

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/css/**").addResourceLocations("resources/css/");
		registry.addResourceHandler("/images/**").addResourceLocations("resources/images/");
	}
	
	@Bean
	public MatchBean matchExpertBean() {
		return new MatchBean();
	}
	
	@Bean
	public AanschafTicketValidator aanschafTicketValidator() {
		return new AanschafTicketValidator();
	}
	@Bean
	public StadiumDao stadiumDao() {
		return new StadiumDaoJPA(Stadium.class);
	}
	
	@Bean
	public DatabankToevoegen databankdinges() {
		return new DatabankToevoegen();
	}
	
	@Bean
	public WedstrijdTicketDao wedstrijdticketDao() {
		return new WedstrijdTicketsDaoJPA(WedstrijdTicket.class);
	}
	
	@Bean 
	GenerischeDao<Wedstrijd> generischeDaoWedstrijddinges() {
		return new GenerischeDaoJPA<>(Wedstrijd.class);
	}
	
	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
	}
}
