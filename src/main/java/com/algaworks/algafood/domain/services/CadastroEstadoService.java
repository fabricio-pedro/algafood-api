package com.algaworks.algafood.domain.services;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.exceptions.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exceptions.EntidadeNaoEncontrada;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repositories.EstadoRepository;

@Service
public class CadastroEstadoService {

	private final EstadoRepository estadoRepository;

	public CadastroEstadoService(EstadoRepository estadoRepository) {
		this.estadoRepository=estadoRepository;
		
	}
	
	public Estado salvar(Estado estado) {	
		return this.estadoRepository.save(estado);
	}
	
	public void excluir(Long id) {
		try {
			this.estadoRepository.deleteById(id);
		}
		catch(EmptyResultDataAccessException ex) {
			throw new EntidadeNaoEncontrada(String.format("Estado com codigo %s não encontrado",id));
		}
		catch(DataIntegrityViolationException ex) {
		  throw new EntidadeEmUsoException(String.format("estado com código: %s nao pode ser removida pois esta em uso", id));	
		}
		
	}
	public List<Estado> listar(){
		return this.estadoRepository.findAll();
	}
	public Estado buscarPor(Long id) {
	  Estado estado = this.estadoRepository
			 .findById(id).orElseThrow(()-> new EntidadeNaoEncontrada(String.format("Estado com código %s não encontrado", id)));
	 return estado;	
	}
	
	
}
