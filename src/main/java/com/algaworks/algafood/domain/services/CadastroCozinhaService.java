package com.algaworks.algafood.domain.services;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algafood.domain.exceptions.CozinhaNaoEncotradaException;
import com.algaworks.algafood.domain.exceptions.EntidadeEmUsoException;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repositories.CozinhaRepository;

@Service
public class CadastroCozinhaService {

	private static final String ENTIDADE_EM_USO = "Cozinha com código: %s nao pode ser removida pois esta em uso";
	private final CozinhaRepository cozinhaRepository;

	public CadastroCozinhaService(CozinhaRepository cozinhaRepository) {
		this.cozinhaRepository=cozinhaRepository;
	}
	
	public List<Cozinha> listar(){
		return this.cozinhaRepository.findAll();
	}
	
	@Transactional
	public Cozinha salvar(Cozinha cozinha) {
		return this.cozinhaRepository.save(cozinha);
	}
	
	@Transactional
	public void excluir(Long id) {
		try {
			this.cozinhaRepository.deleteById(id);
		}
		catch(EmptyResultDataAccessException ex) {
			throw new CozinhaNaoEncotradaException(id);
		}
		catch(DataIntegrityViolationException ex) {
		  throw new EntidadeEmUsoException(String.format(ENTIDADE_EM_USO, id));	
		}
		
	}
 
	public Cozinha buscar(Long id) {
	 return this.cozinhaRepository.findById(id)
			 .orElseThrow(()->  new CozinhaNaoEncotradaException(id));
	}
	
}
