package com.app.microservice;

import com.app.microservice.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UserMicroserviceTests {

	@Autowired
	private MockMvc mvc;
	@Test
	void contextLoads() {
	}

	@Test
	public void getHello() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/api/v1/user/").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	public void addUser() throws Exception {

		User u = new User("Simon", LocalDate.of(2000, 1, 1), "French");
		mvc.perform(MockMvcRequestBuilders
						.post("/api/v1/user/add/")
						//.accept(MediaType.APPLICATION_JSON)
						.param("name", u.getName())
						.param("residence", u.getResidence())
						.param("birthday", u.getBirthday().toString()))
						.andExpect(status().isOk());


	}



}
