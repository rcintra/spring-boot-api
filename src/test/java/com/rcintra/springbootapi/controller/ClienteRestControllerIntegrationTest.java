package com.rcintra.springbootapi.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.rcintra.springbootapi.SpringBootApiApplication;
import com.rcintra.springbootapi.model.Cliente;
import com.rcintra.springbootapi.service.ClienteService;
import com.rcintra.springbootapi.util.JsonUtil;


@WebMvcTest(ClienteController.class)
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = SpringBootApiApplication.class)
@AutoConfigureMockMvc 
// @TestPropertySource(locations = "classpath:application-integrationtest.properties")
@AutoConfigureTestDatabase
public class ClienteRestControllerIntegrationTest {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	public ClienteService service;
	
	@Before
    public void setUp() throws Exception {
    }
	
	@Test
    public void whenPostEmployee_thenCreateEmployee() throws Exception {
		Cliente rafael = new Cliente("rafael");
        given(service.save(Mockito.any())).willReturn(rafael);

        mvc.perform(
        		post("/clientes")
        			.contentType(MediaType.APPLICATION_JSON)
        			.content(JsonUtil.toJson(rafael)))
        		.andExpect(status().isCreated()).andExpect(jsonPath("$.name", is("rafael")));
        
        verify(service, VerificationModeFactory.times(1)).save(Mockito.any());
        
        reset(service);
    }

	
	@Test
	public void givenClientes_whenGetClientes_thenReturnJsonArray()
	  throws Exception {
	    
	    Cliente rafael = new Cliente("rafael");
	 
	    List<Cliente> allEmployees = Arrays.asList(rafael);
	 
	    given(service.getAllClientes()).willReturn(allEmployees);
	 
	    mvc.perform(get("/clientes")
	      .contentType(MediaType.APPLICATION_JSON))
	      .andExpect(status().isOk())
	      .andExpect(jsonPath("$", hasSize(1)))
	      .andExpect(jsonPath("$[0].name", is(rafael.getNome())));
	}
	
}
