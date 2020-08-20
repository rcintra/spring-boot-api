package com.rcintra.springbootapi.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rcintra.springbootapi.domain.OrdemServico;

@Repository
public interface OrdemServiceRepository extends JpaRepository<OrdemServico, Long> {

}
