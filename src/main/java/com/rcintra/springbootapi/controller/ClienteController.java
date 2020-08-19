package com.rcintra.springbootapi.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rcintra.springbootapi.model.Cliente;

@RestController
public class ClienteController {

	@GetMapping("/clientes")
	public List<Cliente> listar() {
		
		var cliente1 = new Cliente();
		cliente1.setId(1L);
		cliente1.setNome("Rafae");
		cliente1.setTelefone("972215432");
		cliente1.setEmail("ra.cintra@gmail.com");
		
		return Arrays.asList(cliente1);
		
	}
}
