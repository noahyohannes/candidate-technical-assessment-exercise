package com.gaggle.server;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class NoahYohanesGaggleInterviewApplicationTestsTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void shouldReturnContactNumber1() throws Exception {
		this.mockMvc.perform(get("/contacts/1")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;")).andExpect(jsonPath("$.contactId").value(1))
				.andExpect(jsonPath("$.firstName").value("Bruce")).andExpect(jsonPath("$.lastName").value("Wayne"));
	}
	
	@Test
	public void shouldReturnContactNumber2() throws Exception {
		this.mockMvc.perform(get("/contacts/2")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;")).andExpect(jsonPath("$.contactId").value(2))
				.andExpect(jsonPath("$.firstName").value("Clark")).andExpect(jsonPath("$.lastName").value("Kent"));
	}
	
	@Test
	public void shouldReturnContactNumber3() throws Exception {
		this.mockMvc.perform(get("/contacts/3")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;")).andExpect(jsonPath("$.contactId").value(3))
				.andExpect(jsonPath("$.firstName").value("Peter")).andExpect(jsonPath("$.lastName").value("Parker"));
	}
	
	@Test
	public void shouldReturnContactNumber4() throws Exception {
		this.mockMvc.perform(get("/contacts/4")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;")).andExpect(jsonPath("$.contactId").value(4))
				.andExpect(jsonPath("$.firstName").value("Tony")).andExpect(jsonPath("$.lastName").value("Stark"));
	}

}
