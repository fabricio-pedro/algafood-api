package com.algaworks.algafood.domain.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algafood.domain.exceptions.ProdutoNaoEncotradoException;
import com.algaworks.algafood.domain.model.Produto;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repositories.ProdutoRepository;

@Service
public class CadastroProdutoService {

	private final ProdutoRepository ProdutoRepository;

	public CadastroProdutoService(ProdutoRepository ProdutoRepository) {
		this.ProdutoRepository=ProdutoRepository;
	}
	
	public List<Produto> listar(){
		return this.ProdutoRepository.findAll();
	}
	
	public List<Produto> listarPorStatus(Restaurante res){
		return this.ProdutoRepository.findProdutosAtivosByRestaurante(res);
	}
	
	public List<Produto> listarDe(Restaurante res){
		return this.ProdutoRepository.findTodosByRestaurante(res);
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
