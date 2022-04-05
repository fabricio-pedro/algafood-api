package com.algaworks.algafood.domain.services;

import java.util.List;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algafood.domain.exceptions.CidadeNaoEncontradaException;
import com.algaworks.algafood.domain.exceptions.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exceptions.EstadoNaoEncontradoException;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.repositories.CidadeRepository;
import com.algaworks.algafood.domain.repositories.EstadoRepository;

@Service
public class CadastroDeCidadeService {
	
	private CidadeRepository cidadeRepository;
	private EstadoRepository estadoRepository;

	public CadastroDeCidadeService(CidadeRepository cidadeRepository, EstadoRepository estadoRepository) {
		super();
		this.cidadeRepository = cidadeRepository;
		this.estadoRepository=estadoRepository;
	}
	
	public List<Cidade> listar(){
		return this.cidadeRepository.findAll();
	}
	
	@Transactional
	public Cidade salvar(Cidade cidade) {
		var estadoId=cidade.getEstado().getId();
		var estadoOpt=estadoRepository.findById(estadoId);
	    var estado=estadoOpt.orElseThrow(()->new EstadoNaoEncontradoException(estadoId));
	    cidade.setEstado(estado);
	    var cidadeSalva=this.cidadeRepository.save(cidade);
	    return cidadeSalva;	
		
		
	}
	@Transactional
	public void excluir(Long id) {
		try {
		   this.cidadeRepository.deleteById(id);
		}catch (EmptyResultDataAccessException ex) {
			throw new CidadeNaoEncontradaException(id);
		}catch(DataIntegrityViolationException ex) {
			throw new EntidadeEmUsoException(String.format("A cidade com codigo %s nao pode ser removida porque estado em uso", id));
			
		}
	
   		
	}
	public Cidade buscar(Long id) {
		 return this.cidadeRepository.findById(id)
				                     .orElseThrow(()->new CidadeNaoEncontradaException(id));   
	   }
	

}
