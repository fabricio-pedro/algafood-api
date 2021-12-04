package com.algaworks.algafood.domain.repositories;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.algafood.domain.model.Cozinha;
public interface CozinhaRepository extends JpaRepository<Cozinha, Long> {
	@Override
	default <S extends Cozinha> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
