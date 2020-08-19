package com.rcintra.springbootapi.service.impl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rcintra.springbootapi.domain.repository.ClienteRepository;
import com.rcintra.springbootapi.model.Cliente;
import com.rcintra.springbootapi.service.ClienteService;

@Service
@Transactional
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente findByNome(String nome) {
		return clienteRepository.findByNome(nome);
	}

	@Override
	public Optional<Cliente> getClienteById(Long id) {		
		return clienteRepository.findById(id);
	}

	@Override
	public Cliente getClienteByNome(String nome) {
		return clienteRepository.findByNome(nome);
	}

	@Override
	public List<Cliente> getAllClientes() {
		return clienteRepository.findAll();
	}

	@Override
	public boolean exists(Long id) {
		 return clienteRepository.existsById(id);
	}

	@Override
	public Cliente save(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	@Override
	public void deleteById(Long id) {
		clienteRepository.deleteById(id);
	}
}
