package com.algaworks.algafood.domain.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;

import com.algaworks.algafood.domain.model.FotoProduto;

public interface ProdutoRepositoryQueries {
  
	FotoProduto save(FotoProduto foto); 

	void delete(FotoProduto foto);
}
