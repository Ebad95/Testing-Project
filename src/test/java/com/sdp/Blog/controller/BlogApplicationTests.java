package com.sdp.Blog.controller;

import com.sdp.Blog.model.User;
import com.sdp.Blog.payload.request.LoginRequest;
import com.sdp.Blog.service.UserService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class BlogApplicationTests {

	@Autowired
	private UserService userService;
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	ObjectMapper objectMapper;

	@Test
	void contextLoads() {
	}

	// @Test
	// public void contextLoadsTest() {
	// assertEquals(2, 2);
	// }


    //Predicate 1  if (signUpRequest.getUsername() == null || signUpRequest.getEmail().length() < 4 || signUpRequest.getPassword().length()<4)
	// At line 88 in /controller/AuthController.java
	//clause a: signUpRequest.getUsername() == null
	//clause b: signUpRequest.getEmail().length() < 4
	//clause c: signUpRequest.getPassword().length()<4

	// Test case 1: when a is major clause and b and c are minor
	// Predicate is True , when a is True , b is False, c is False
	@Test
	public void registerUserTest1() throws Exception {

		User user = new User(null, "rajatkumar@gmail.com", "rajat123", "RajatKumar");
		mockMvc.perform(MockMvcRequestBuilders.post("/api/auth/register").contentType("application/json")
				.content(objectMapper.writeValueAsString(user))).andExpect(status().isBadRequest());
	}

	//Test case 2: When a is major clause and b,c is minor
	// Predicate is False when a is false,b is false,c is false
	@Test
	public void registerUserTest2() throws Exception {

		User user = new User("RajatKumar", "rajatkumar@gmail.com", "rajat1352", "Rajatkumar");
		mockMvc.perform(MockMvcRequestBuilders.post("/api/auth/register").contentType("application/json")
				.content(objectMapper.writeValueAsString(user))).andExpect(status().isOk());
	}

	//Test case 3: When b is major clause, a and c are minor
	//Predicate is True, when b is True and a is false,c is false
	@Test
	public void registerUserTest3() throws Exception {

		User user = new User("RajatKumar", "raj", "rajat1336", "Rajatkumar");
		mockMvc.perform(MockMvcRequestBuilders.post("/api/auth/register").contentType("application/json")
				.content(objectMapper.writeValueAsString(user))).andExpect(status().isBadRequest());
	}
	//Test case 4: When b is major clause, a and c are minor
	//Predicate is False, when b is False and a is false,c is false
	@Test
	public void registerUserTest4() throws Exception {

		User user = new User("RajatKumar", "rajatkumar@gmail.com", "rajat1352", "Rajatkumar");
		mockMvc.perform(MockMvcRequestBuilders.post("/api/auth/register").contentType("application/json")
				.content(objectMapper.writeValueAsString(user))).andExpect(status().isOk());
	}

	//Test case 5: when c is major clause, a and b are minor
	//Predicate is True , when c is True, a and b are false
	@Test
	public void registerUserTest5() throws Exception {

		User user = new User("RajatKumar", "rajatkumar@gmail.com", "rajat1366", "Raj");
		mockMvc.perform(MockMvcRequestBuilders.post("/api/auth/register").contentType("application/json")
				.content(objectMapper.writeValueAsString(user))).andExpect(status().isBadRequest());
	}
	//Test case 6: When c is major clause, a and b are minor
	//Predicate is False, when c is False and a is false,b is false
	@Test
	public void registerUserTest6() throws Exception {

		User user = new User("RajatKumar", "rajatkumar@gmail.com", "rajat1352", "Rajatkumar");
		mockMvc.perform(MockMvcRequestBuilders.post("/api/auth/register").contentType("application/json")
				.content(objectMapper.writeValueAsString(user))).andExpect(status().isOk());
	}
	//Predicate 2  if(signUpRequest.getName() == null || signUpRequest.getEmail().length() >40 || signUpRequest.getUsername().length()<4)
	// At line 93 in /controller/AuthController.java
	//clause a: signUpRequest.getName() == null
	//clause b: signUpRequest.getEmail().length() > 40
	//clause c: signUpRequest.getUsername().length()<4

	// Test case 7: when a is major clause and b and c are minor
	// Predicate is True , when a is True , b is False, c is False

	@Test
	public void registerUserTest7() throws Exception {

		User user = new User("ebadhusain", "ebadhusain@gmail.com", null, "ebadhusain");
		mockMvc.perform(MockMvcRequestBuilders.post("/api/auth/register").contentType("application/json")
				.content(objectMapper.writeValueAsString(user))).andExpect(status().isBadRequest());
	}

	//Test case 8: When a is major clause and b,c is minor
	// Predicate is False when a is false,b is false,c is false

	@Test
	public void registerUserTest8() throws Exception {

		User user = new User("RajatKumar", "rajatkumar@gmail.com", "rajat1352", "Rajatkumar");
		mockMvc.perform(MockMvcRequestBuilders.post("/api/auth/register").contentType("application/json")
				.content(objectMapper.writeValueAsString(user))).andExpect(status().isOk());
	}
	//Test case 9: When b is major clause, a and c are minor
	//Predicate is True, when b is True and a is false,c is false
	@Test
	public void registerUserTest9() throws Exception {

		User user = new User("ebadhusain", "ebadhusain@gmail.comebad.husain@gmail.comebad", "ebadhusain", "ebadhusain");
		mockMvc.perform(MockMvcRequestBuilders.post("/api/auth/register").contentType("application/json")
				.content(objectMapper.writeValueAsString(user))).andExpect(status().isBadRequest());
	}
	//Test case 10: When b is major clause, a and c are minor
	//Predicate is False, when b is False and a is false,c is false
	@Test
	public void registerUserTest10() throws Exception {

		User user = new User("RajatKumar", "rajatkumar@gmail.com", "rajat1352", "Rajatkumar");
		mockMvc.perform(MockMvcRequestBuilders.post("/api/auth/register").contentType("application/json")
				.content(objectMapper.writeValueAsString(user))).andExpect(status().isOk());
	}
	//Test case 11: when c is major clause, a and b are minor
	//Predicate is True , when c is True, a and b are false
	@Test
	public void registerUserTest11() throws Exception {

		User user = new User("eba", "ebadhusain@gmail.com", "ebadhusain", "ebadhusain");
		mockMvc.perform(MockMvcRequestBuilders.post("/api/auth/register").contentType("application/json")
				.content(objectMapper.writeValueAsString(user))).andExpect(status().isBadRequest());
	}

	//Test case 12: When c is major clause, a and b are minor
	//Predicate is False, when c is False and a is false,b is false

	@Test
	public void registerUserTest12() throws Exception {

		User user = new User("RajatKumar", "rajatkumar@gmail.com", "rajat1352", "Rajatkumar");
		mockMvc.perform(MockMvcRequestBuilders.post("/api/auth/register").contentType("application/json")
				.content(objectMapper.writeValueAsString(user))).andExpect(status().isOk());
	}
	//Predicate 3  if(loginRequest.getUsername() == null || loginRequest.getUsername().length() == 0 || loginRequest.getPassword().length()==0)
	// At line 53 in /controller/AuthController.java
	//clause a: loginRequest.getUsername() == null
	//clause b: loginRequest.getUsername().length() == 0
	//clause c:  loginRequest.getPassword().length()==0

	// Test case 13: when a is major clause and b and c are minor
	// Predicate is True , when a is True , b is False, c is False

	@Test
	public void loginUserTest13() throws Exception {

		LoginRequest loginrequest = new LoginRequest(null,"ebadhusain");
		mockMvc.perform(MockMvcRequestBuilders.post("/api/auth/login").contentType("application/json")
				.content(objectMapper.writeValueAsString(loginrequest))).andExpect(status().isBadRequest());
	}

	//Test case 14: When a is major clause and b,c is minor
	// Predicate is False when a is false,b is false,c is false

	@Test
	public void loginUserTest14() throws Exception {

		LoginRequest loginrequest = new LoginRequest("ebadhusain","ebadhusain");
		mockMvc.perform(MockMvcRequestBuilders.post("/api/auth/login").contentType("application/json")
				.content(objectMapper.writeValueAsString(loginrequest))).andExpect(status().isOk());
	}

	//Test case 15: When b is major clause, a and c are minor
	//Predicate is True, when b is True and a is false,c is false

	@Test
	public void loginUserTest15() throws Exception {

		LoginRequest loginrequest = new LoginRequest("","ebadhusain");
		mockMvc.perform(MockMvcRequestBuilders.post("/api/auth/login").contentType("application/json")
				.content(objectMapper.writeValueAsString(loginrequest))).andExpect(status().isBadRequest());
	}
	//Test case 16: When b is major clause, a and c are minor
	//Predicate is False, when b is False and a is false,c is false

	@Test
	public void loginUserTest16() throws Exception {

		LoginRequest loginrequest = new LoginRequest("ebadhusain","ebadhusain");
		mockMvc.perform(MockMvcRequestBuilders.post("/api/auth/login").contentType("application/json")
				.content(objectMapper.writeValueAsString(loginrequest))).andExpect(status().isOk());
	}

	//Test case 17: when c is major clause, a and b are minor
	//Predicate is True , when c is True, a and b are false

	@Test
	public void loginUserTest17() throws Exception {

		LoginRequest loginrequest = new LoginRequest("ebadhusain","");
		mockMvc.perform(MockMvcRequestBuilders.post("/api/auth/login").contentType("application/json")
				.content(objectMapper.writeValueAsString(loginrequest))).andExpect(status().isBadRequest());
	}

	//Test case 18: When c is major clause, a and b are minor
	//Predicate is False, when c is False and a is false,b is false

	@Test
	public void loginUserTest18() throws Exception {

		LoginRequest loginrequest = new LoginRequest("ebadhusain","ebadhusain");
		mockMvc.perform(MockMvcRequestBuilders.post("/api/auth/login").contentType("application/json")
				.content(objectMapper.writeValueAsString(loginrequest))).andExpect(status().isOk());
	}
	//Predicate 4 if(searchData !=null && page>0 && size>1)
	// At line 50 in /controller/ArticleController.java
	//clause a: searchData !=null
	//clause b: page>0
	//clause c: size>1

	//Test case 19: when a is major clause and b and c are minor
	//Predicate is True when a is True , b is True , c is True

	@Test
	public void ArticleTest19() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/api/article/")
				.param("searchData","pizza")
				.param("page","1")
				.param("size","2"))
				.andExpect(status().isOk());
	}
	//Test case 20: when a is major clause and b and c are minor
	//Predicate is False when a is False , b is True , c is True
	@Test
	public void ArticleTest20() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/api/article/")
				.param("searchData","")
				.param("page","1")
				.param("size","2"))
				.andExpect(status().isOk());
	}
	//Test case 21: when b is major clause and a and c are minor
	//Predicate is True when b is True , a is True , c is True
	@Test
	public void ArticleTest21() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/api/article/")
				.param("searchData","pizza")
				.param("page","1")
				.param("size","2"))
				.andExpect(status().isOk());
	}
	//Test case 22: when b is major clause and a and c are minor
	//Predicate is False when b is False , a is True , c is True

	@Test
	public void ArticleTest22() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/api/article/")
				.param("searchData","pizza")
				.param("page","0")
				.param("size","2"))
				.andExpect(status().isBadRequest());
	}
	//Test case 23: when c is major clause and a and b are minor
	//Predicate is True when c is True , a is True , b is True
	@Test
	public void ArticleTest23() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/api/article/")
				.param("searchData","pizza")
				.param("page","1")
				.param("size","2"))
				.andExpect(status().isOk());
	}
	//Test case 24: when c is major clause and a and b are minor
	//Predicate is False when c is False , a is True , b is True
	@Test
	public void ArticleTest24() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/api/article/")
				.param("searchData","pizza")
				.param("page","1")
				.param("size","1"))
				.andExpect(status().isBadRequest());
	}

}
