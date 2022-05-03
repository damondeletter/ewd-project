package com.springBoot.fifa;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;

import domain.Wedstrijd;
import domain.WedstrijdTicket;
import service.VoetbalServiceImpl;

public class FifaControllerMockTest {

	private FifaController fifa;
	private MockMvc mockMvc;
	
	@Mock
	private VoetbalServiceImpl mock;
	
	@BeforeEach
	public void before() {
		MockitoAnnotations.openMocks(this);
		fifa = new FifaController();
		mockMvc = standaloneSetup(fifa).build();
	}
	
	@Test
	public void testFifaPostGeldig() throws Exception {
		 WedstrijdTicket expResult 
		 = new WedstrijdTicket(new Wedstrijd("1",new String[]{"België", "Canada"}, 26, 21), 35);
		 Mockito.when(mock.getWedstrijd("1")).thenReturn(expResult);
		 //injection hieronder
		 ReflectionTestUtils.setField(fifa, "wedstrijdLookup", mock);
		 
		 mockMvc.perform(post("/fifa").param("stadiumList","Al Thumama Stadium"));
		 mockMvc.perform(post("/fifa/1").param("id", "1")).andExpect(view().name("buyTickets"));				
		 
		 
	}
}
