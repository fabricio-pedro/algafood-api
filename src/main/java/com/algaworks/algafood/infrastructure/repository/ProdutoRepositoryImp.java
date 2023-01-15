package com.algaworks.algafood.infrastructure.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.algaworks.algafood.domain.model.FotoProduto;
import com.algaworks.algafood.domain.repositories.ProdutoRepository;
import com.algaworks.algafood.domain.repositories.ProdutoRepositoryQueries;

@Repository
public class ProdutoRepositoryImp implements ProdutoRepositoryQueries {
	@PersistenceContext
	private EntityManager manager;
    
	@Transactional
	@Override
	public FotoProduto save(FotoProduto foto) {
		// TODO Auto-generated method stub
		return manager.merge(foto);
	}
}
