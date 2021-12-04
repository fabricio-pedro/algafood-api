package com.algaworks.algafood.domain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.exceptions.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exceptions.EntidadeNaoEncontrada;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repositories.CozinhaRepository;
import com.algaworks.algafood.domain.repositories.RestauranteRepository;

@Service
public class CadastroRestauranteService {

	private final RestauranteRepository restauranteRepository;
	private final CozinhaRepository cozinhaRepository;

	public CadastroRestauranteService(RestauranteRepository restauranteRepository,CozinhaRepository cozinhaRepository) {
		this.restauranteRepository=restauranteRepository;
		this.cozinhaRepository=cozinhaRepository;
	}
	
	public Restaurante salvar(Restaurante restaurante) {
		var cozinhaId=restaurante.getCozinha().getId();
		 Optional<Cozinha> cozinhaOpt=this.cozinhaRepository.findById(cozinhaId);
		 Cozinha cozinha =cozinhaOpt.orElseThrow(()-> new EntidadeNaoEncontrada(String.format("Cozinha com codigo %s nao está cadastrada",cozinhaId)));
		 restaurante.setCozinha(cozinha);
		 return this.restauranteRepository.save(restaurante);
	}
	
	public void excluir(Long id) {
		try {
			this.restauranteRepository.deleteById(id);
		}
		catch(EmptyResultDataAccessException ex) {
			throw new EntidadeNaoEncontrada(String.format("Entidade com codigo %s não encontrada",id));
		}
		catch(DataIntegrityViolationException ex) {
		  throw new EntidadeEmUsoException(String.format("Restaurante com código: %s nao pode ser removido pois esta em uso", id));	
		}
		
	}
	public List<Restaurante> listar(){
		return this.restauranteRepository.findAll();
	}
	public Restaurante buscar(Long restauranteId) {
		Optional<Restaurante> restauranteOp =restauranteRepository.findById(restauranteId);
		Restaurante restaurante=restauranteOp.orElseThrow(()->  new EntidadeNaoEncontrada(String.format("Entidade com codigo %s não encontrada",restauranteId)));
        return restaurante;		
	}
}
