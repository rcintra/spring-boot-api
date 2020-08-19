package com.rcintra.springbootapi.domain.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.rcintra.springbootapi.SpringBootApiApplicationTests;
import com.rcintra.springbootapi.model.Cliente;

@Transactional
public class ClienteRepositoryIntegrationTest extends SpringBootApiApplicationTests {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Before
    public void setUp() {
		clienteRepository.save(new Cliente("Rafael","rafael@rcintra.com","11 97221-5432"));
		clienteRepository.save(new Cliente("Dani", "dani@rcintra.com", "11 97773-3223"));
    }
	
	@Test
    public void testFindByNome() {
        Cliente rafael = clienteRepository.findByNome("Rafael");

        assertThat(rafael, notNullValue());
        assertThat(rafael.getId(), notNullValue());
        assertThat(rafael.getNome(), is("Rafael"));
    }
	
	@Test
	public void whenFindByName_thenReturnCliente() {
		Cliente rafael = new Cliente("Rafael");
		
		//when
		Cliente found = clienteRepository.findByNome("Rafael");
		
		assertThat(found.getNome())
			.isEqualTo(rafael.getNome());
		
	}
}
