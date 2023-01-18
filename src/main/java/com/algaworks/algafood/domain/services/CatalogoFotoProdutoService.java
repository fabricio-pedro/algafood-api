package com.algaworks.algafood.domain.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.model.FotoProduto;
import com.algaworks.algafood.domain.repositories.ProdutoRepository;

@Service
public class CatalogoFotoProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Transactional
	public FotoProduto salvar(FotoProduto fotoProduto) {
		 var restauranteId=fotoProduto.getRestauranteId();
		 var produtoId=fotoProduto.getProduto().getId();
		 Optional<FotoProduto> fotoExiste=this.produtoRepository.findFotoById(restauranteId, produtoId);
			
			  if(fotoExiste.isPresent()) { this.produtoRepository.delete(fotoExiste.get());
			  
			  }
			 
		return this.produtoRepository.save(fotoProduto);
	}
	
}
