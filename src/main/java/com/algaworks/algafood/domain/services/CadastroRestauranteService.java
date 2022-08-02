package com.algaworks.algafood.domain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algafood.domain.exceptions.CidadeNaoEncontradaException;
import com.algaworks.algafood.domain.exceptions.CozinhaNaoEncotradaException;
import com.algaworks.algafood.domain.exceptions.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exceptions.RestauranteNaoEncontradoException;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repositories.CidadeRepository;
import com.algaworks.algafood.domain.repositories.CozinhaRepository;
import com.algaworks.algafood.domain.repositories.RestauranteRepository;

@Service
public class CadastroRestauranteService {
    @Autowired
	private  RestauranteRepository restauranteRepository;
    @Autowired
    private  CozinhaRepository cozinhaRepository;
    @Autowired
    private  CidadeRepository cidadeRepository;
    @Autowired
    private  CadastroFormaPagamentoService formaPagamentoService;
	
	@Transactional
	public Restaurante salvar(Restaurante restaurante) {
		 var cozinhaId=restaurante.getCozinha().getId();
		 var cidadeId=restaurante.getEndereco().getCidade().getId();
		 Optional<Cidade> cidadeOpt=this.cidadeRepository.findById(cidadeId);
		 Optional<Cozinha> cozinhaOpt=this.cozinhaRepository.findById(cozinhaId);
		 var cozinha =cozinhaOpt.orElseThrow(()-> new CozinhaNaoEncotradaException(cozinhaId));
		 var cidade=cidadeOpt.orElseThrow(()->new CidadeNaoEncontradaException(cidadeId));
		 restaurante.setCozinha(cozinha);
		 restaurante.getEndereco().setCidade(cidade);
		 return this.restauranteRepository.save(restaurante);
	}
	
	@Transactional
	public void excluir(Long id) {
		try {
			this.restauranteRepository.deleteById(id);
		}
		catch(EmptyResultDataAccessException ex) {
			throw new RestauranteNaoEncontradoException(id);
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
		Restaurante restaurante=restauranteOp.orElseThrow(()->  new RestauranteNaoEncontradoException(restauranteId));
        return restaurante;		
	}
	
	@Transactional
	public void ativar(Long id) {
	 var restauranteAtual=buscar(id);
	 restauranteAtual.ativar();
	 
	 
	}
	@Transactional
	public void inativar(Long id) {
	 var restauranteAtual=buscar(id);
	 restauranteAtual.inativar();
	 
	 
	}
	@Transactional
	public void abrir(Long id) {
	 var restauranteAtual=buscar(id);
	 restauranteAtual.abrir();
	 
	 
	}
	@Transactional
	public void fechar(Long id) {
	 var restauranteAtual=buscar(id);
	 restauranteAtual.fechar();
	 
	 
	}
	

	
	
	@Transactional
	public void associarFormaPagamento(Long restaurenteId, Long id) {
	   var restaurante =this.buscar(restaurenteId);
	   var formaPagamento=this.formaPagamentoService.buscarPor(id);
	   restaurante.addicionarFormaPagamento(formaPagamento);
	}
	
	@Transactional
	public void desassociarFormaPagamento(Long restaurenteId, Long id) {
		   var restaurante =this.buscar(restaurenteId);
		   var formaPagamento=this.formaPagamentoService.buscarPor(id);
		   restaurante.removerFormaPagamento(formaPagamento);
		}
}
