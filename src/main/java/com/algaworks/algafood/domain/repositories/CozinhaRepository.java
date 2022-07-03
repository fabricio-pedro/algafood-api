package com.algaworks.algafood.domain.repositories;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.algafood.domain.model.Cozinha;
public interface CozinhaRepository extends JpaRepository<Cozinha, Long> {
	
	

}
