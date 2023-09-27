/**
 * @package com.app.test;
 * <p> This package comprises the functional and integration tests for the @package com.app.microservice. </p>
 * It comprises two main classes
 * @see com.app.test.UserMicroserviceTests
 * @see com.app.test.UserServiceTests
 */
package com.app.test;

import com.app.microservice.model.User;
import io.swagger.v3.core.util.Json;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

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

	/**
	 * Checking if the API is functional and responds correctly.
	 * @throws Exception
	 */
	@Test
	public void getHelloAPI() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/api/v1/user/").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	/**
	 * AddUser API call.
	 * It is responsible for adding new users.
	 * This test adds an adult user who resides in French.
	 * It excepts to receive the status 200
	 * @throws Exception
	 */
	@Test
	public void addUserAPI() throws Exception {

		User u = new User("someone" , LocalDate.of(2000,1,1), "French");
		mvc.perform(MockMvcRequestBuilders
						.post("/api/v1/user/add")
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON)
						.content(Json.pretty(u))
						//.param("name", u.getName())
						//.param("residence", u.getResidence())
						//.param("birthday", u.getBirthday().toString())
						)

						.andExpect(status().isOk());


	}

	/**
	 * Testing the getUser api call,
	 * This call expects finding a user who has the Id 1 and named as someone
	 * @throws Exception
	 */
	@Test
	public void getUserAPI() throws Exception {
		addUserAPI();
		 mvc.perform(MockMvcRequestBuilders
						.get("/api/v1/user/get/1"))
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.name").value("someone"));

	}

	/**
	 * getUsersAPI API call.
	 * It is responsible for listing users.
	 * It excepts to receive the status 200
	 * @throws Exception
	 */
	@Test
	public void getUsersAPI() throws Exception {
		addUserAPI();
		mvc.perform(MockMvcRequestBuilders
						.get("/api/v1/user/users"))
				.andExpect(status().isOk())
				.andReturn();

	}

	/**
	 * updateUserAPI API call.
	 * It is responsible for updating a user.
	 * It excepts to receive the status 200
	 * @throws Exception
	 */
	@Test
	public void updateUserAPI() throws Exception
	{
		User u = new User(1,"Biden" , LocalDate.of(1950,1,1), "USA");
		mvc.perform( MockMvcRequestBuilders
						.put("/api/v1/user/update", 2)
						.content(Json.pretty(u))
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.name").value("User"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.residence").value("USA"));
	}

	/**
	 * deleteUser API call.
	 * It is responsible for deleting a user.
	 * It excepts to receive the status 200
	 * @throws Exception
	 */
	@Test
	public void deleteUser () throws Exception
	{
		mvc.perform( MockMvcRequestBuilders.delete("/api/v1/user/delete/1", 1) )
				.andExpect(status().isOk());
	}




}
