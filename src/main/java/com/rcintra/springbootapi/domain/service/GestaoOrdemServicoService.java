package com.rcintra.springbootapi.domain.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rcintra.springbootapi.domain.OrdemServico;
import com.rcintra.springbootapi.domain.StatusOrdemServico;
import com.rcintra.springbootapi.domain.exception.CadastroException;
import com.rcintra.springbootapi.domain.repository.ClienteRepository;
import com.rcintra.springbootapi.domain.repository.OrdemServiceRepository;
import com.rcintra.springbootapi.model.Cliente;

@Service
public class GestaoOrdemServicoService {
	
	@Autowired
	private OrdemServiceRepository ordemServiceRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;

	public OrdemServico criar(OrdemServico ordemServico) {
		Cliente cliente = clienteRepository.findById(ordemServico.getCliente().getId())
				.orElseThrow(() -> new CadastroException("Cliente não encontrado"));
		
		ordemServico.setCliente(cliente);
		ordemServico.setStatus(StatusOrdemServico.ABERTA);
		ordemServico.setDataAbertura(LocalDateTime.now());
		
		return ordemServiceRepository.save(ordemServico);
	}
}
