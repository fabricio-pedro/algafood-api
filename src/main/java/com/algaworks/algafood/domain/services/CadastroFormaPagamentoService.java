package com.algaworks.algafood.domain.services;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algafood.domain.exceptions.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exceptions.FormaPagamentoNaoEncontradoException;
import com.algaworks.algafood.domain.model.FormaPagamento;
import com.algaworks.algafood.domain.repositories.FormaPagamentoRepository;

@Service
public class CadastroFormaPagamentoService {

	private final FormaPagamentoRepository formaPgRepository;

	public CadastroFormaPagamentoService(FormaPagamentoRepository formaPgRepository) {
		this.formaPgRepository=formaPgRepository;
		
	}
	
	@Transactional
	public FormaPagamento salvar(FormaPagamento estado) {	
		return this.formaPgRepository.save(estado);
	}
	
	@Transactional
	public void excluir(Long id) {
		try {
			this.formaPgRepository.deleteById(id);
		}
		catch(EmptyResultDataAccessException ex) {
			throw new FormaPagamentoNaoEncontradoException(id);
		}
		catch(DataIntegrityViolationException ex) {
		  throw new EntidadeEmUsoException(String.format("forma de pagamento com código: %s nao pode ser removida pois esta em uso", id));	
		}
		
	}
	public List<FormaPagamento> listar(){
		return this.formaPgRepository.findAll();
	}
	public FormaPagamento buscarPor(Long id) {
	  FormaPagamento formaPagamento = this.formaPgRepository
			 .findById(id).orElseThrow(()-> new FormaPagamentoNaoEncontradoException(id));
	 return formaPagamento;	
	}
	
	
}
