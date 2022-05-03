package com.springBoot.fifa;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@SpringBootTest
public class FIfaControllerTest {
	
	@Autowired
	private WebApplicationContext wac;
	
	private MockMvc mockMvc;
	
	@BeforeEach
	public void before() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	@Test
	public void testFifaGet() throws Exception {
		mockMvc.perform(get("/fifa"))
		.andExpect(status().isOk())
		.andExpect(view().name("startScreen"));
	}

	@Test
	public void testFifaPost() throws Exception {
		mockMvc.perform(post("/fifa").param("stadiumList","Al Thumama Stadium"))
			.andExpect(status().isOk())
			.andExpect(view().name("overviewMatches"))
			.andExpect(model().attributeExists("stadium"))
			.andExpect(model().attributeExists("listMatch"))
			.andExpect(model().attributeExists("match"));
	}
	
	@Test
	public void testFifaGetSpecificMatch() throws Exception {
		mockMvc.perform(get("/fifa/2"))
			.andExpect(status().isOk())
			.andExpect(view().name("buyTickets"))
			.andExpect(model().attributeExists("aanschafTicket"))
			.andExpect(model().attributeExists("stadium"))
			.andExpect(model().attributeExists("tickets"))
			.andExpect(model().attributeExists("wedstrijdnaam"))
			.andExpect(model().attributeDoesNotExist("listStadia"));
	}
	
	@Test
	public void testDoesNotPostForm() throws Exception {
		mockMvc.perform(post("/fifa").param("stadiumList","Al Thumama Stadium"));
		mockMvc.perform(post("/fifa/4")
				.param("email", "damon.deletter5@gmail.com")
				.param("tickets", "-5")
				.param("voetbalCode1", "-5")
				.param("voetbalCode2","22")
				)
				.andExpect(status().is(200))
				.andExpect(status().is3xxRedirection())
				.andExpect(redirectedUrl("/fifa?verkocht=5"));
	}
	
	@Test
	public void testPostForm() throws Exception {
		mockMvc.perform(post("/fifa").param("stadiumList","Al Thumama Stadium"));
		mockMvc.perform(post("/fifa/4")
			.param("email", "damon.deletter5@gmail.com")
			.param("tickets", "5")
			.param("voetbalCode1", "15")
			.param("voetbalCode2","22")
			)
			.andExpect(status().isOk())
			.andExpect(status().is3xxRedirection())
			.andExpect(redirectedUrl("/fifa?verkocht=5"));
	}
	
	@Test
	public void testNoEmailPostForm() throws Exception {
		mockMvc.perform(post("/fifa").param("stadiumList", "Al Thunama Stadium"));
		mockMvc.perform(post("/fifa/4")
				.param("email", "")
				.param("tickets", "5")
				.param("voetbalCode1", "15")
				.param("voetbalCode2", "22")
				)
				.andExpect(view().name("buyTickets"))
				.andExpect(status().isOk());	
	}
	@Test
	public void testWrongTicketsPostForm() throws Exception {
		mockMvc.perform(post("/fifa").param("stadiumList", "Al Thunama Stadium"));
		mockMvc.perform(post("/fifa/4")
				.param("email", "damon.deletter@student.hogent.be")
				.param("tickets", "0")
				.param("voetbalCode1", "15")
				.param("voetbalCode2", "22")
				)
				.andExpect(view().name("buyTickets"))
				.andExpect(status().isOk());	
	}
	
}
