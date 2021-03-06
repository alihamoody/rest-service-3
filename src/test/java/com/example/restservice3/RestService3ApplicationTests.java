package com.example.restservice3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.restservice3.models.Account;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.hamcrest.Matchers.containsString;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class RestService3ApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() {
	}

	@Test
	void test0() {
		assertEquals(2, 1+1, "1+1 failed!");
	}

	@Test
	public void shouldReturnDefaultMessage() throws Exception {
		this.mockMvc.perform(get("/hello"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("Hello World!")));
	}

	@Test
	public void getAllAccountsTest() throws Exception {
		mockMvc.perform(
			get("/accounts")
			.accept(MediaType.APPLICATION_JSON)
			)
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$[*]").exists())
		.andExpect(MockMvcResultMatchers.jsonPath("$[*].id").isNotEmpty())
		.andExpect(MockMvcResultMatchers.jsonPath("$[0].title").value("Title2"));
	}

	@Test
	public void getAccountByIdTest() throws Exception {
		mockMvc.perform(
			get("/accounts/2")
			.accept(MediaType.APPLICATION_JSON)
			)
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$[*]").exists())
		.andExpect(MockMvcResultMatchers.jsonPath("$.id").value(2));
	}

	@Test
	public void shouldCreateNewAccount() throws Exception {
		this.mockMvc.perform(
			post("/accounts")
			.contentType(MediaType.APPLICATION_JSON_VALUE)
			.content(new ObjectMapper().writeValueAsString(new Account("Title Test", "Description Test", 1L))))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("Saved")));
	}

	@Test
	public void shouldUpdateExistingAccount() throws Exception {
		this.mockMvc.perform(
			put("/accounts/1")
			.contentType(MediaType.APPLICATION_JSON_VALUE)
			.content(new ObjectMapper().writeValueAsString(new Account("Title 1T", "Desc 1T", 1L))))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("Updated")));
	}

	// @Test
	// public void shouldDeleteAccount() throws Exception {
	// 	this.mockMvc.perform(
	// 		delete("/accounts/1")
	// 	)
	// 	.andDo(print())
	// 	.andExpect(status().isOk())
	// 	.andExpect(content().string(containsString("Deleted")));
	// }
}
