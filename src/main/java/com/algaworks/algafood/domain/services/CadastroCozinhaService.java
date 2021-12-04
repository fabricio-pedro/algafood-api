package com.algaworks.algafood.domain.services;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.exceptions.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exceptions.EntidadeNaoEncontrada;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repositories.CozinhaRepository;

@Service
public class CadastroCozinhaService {

	private final CozinhaRepository cozinhaRepository;

	public CadastroCozinhaService(CozinhaRepository cozinhaRepository) {
		this.cozinhaRepository=cozinhaRepository;
	}
	
	public List<Cozinha> listar(){
		return this.cozinhaRepository.findAll();
	}
	
	public Cozinha salvar(Cozinha cozinha) {
		return this.cozinhaRepository.save(cozinha);
	}
	
	public void excluir(Long id) {
		try {
			this.cozinhaRepository.deleteById(id);
		}
		catch(EmptyResultDataAccessException ex) {
			throw new EntidadeNaoEncontrada(String.format("Entidade com codigo %s não encontrada",id));
		}
		catch(DataIntegrityViolationException ex) {
		  throw new EntidadeEmUsoException(String.format("Cozinha com código: %s nao pode ser removida pois esta em uso", id));	
		}
		
	}
 
	public Cozinha buscar(Long id) {
	 return this.cozinhaRepository.findById(id)
			 .orElseThrow(()->  new EntidadeNaoEncontrada(String.format("Entidade com codigo %s não encontrada",id)));	
	}
	
}
