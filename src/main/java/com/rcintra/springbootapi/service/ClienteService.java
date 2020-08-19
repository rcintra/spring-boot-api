package com.rcintra.springbootapi.service;

import java.util.List;
import java.util.Optional;

import com.rcintra.springbootapi.model.Cliente;

public interface ClienteService {
	
	public Optional<Cliente> getClienteById(Long id);

    public Cliente getClienteByNome(String name);

    public List<Cliente> getAllClientes();

    public boolean exists(Long id);

    public Cliente save(Cliente Cliente);
    
    public void deleteById(Long id);

}
