package com.algaworks.algafood.domain.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algafood.domain.exceptions.ProdutoNaoEncotradoException;
import com.algaworks.algafood.domain.model.Produto;
import com.algaworks.algafood.domain.repositories.ProdutoRepository;

@Service
public class CadastroProdutoService {

	private static final String ENTIDADE_EM_USO = "Produto com código %s nao pode ser removido pois esta em uso";
	private final ProdutoRepository ProdutoRepository;

	public CadastroProdutoService(ProdutoRepository ProdutoRepository) {
		this.ProdutoRepository=ProdutoRepository;
	}
	
	public List<Produto> listar(){
		return this.ProdutoRepository.findAll();
	}
	
	@Transactional
	public Produto salvar(Produto Produto) {
		return this.ProdutoRepository.save(Produto);
	}
	
	
	
 
	public Produto buscar(Long restauranteId,Long produtoId) {
	  var produtoOpt=this.ProdutoRepository.findByProdutoIdAndRestauranteId(produtoId, restauranteId);
	   return produtoOpt.orElseThrow(()->new ProdutoNaoEncotradoException(restauranteId, produtoId));
	}
	
  

	
}
