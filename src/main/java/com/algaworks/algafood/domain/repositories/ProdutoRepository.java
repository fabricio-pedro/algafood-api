package com.algaworks.algafood.domain.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.algaworks.algafood.domain.model.Produto;

@Repository                      
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    @Query ("SELECT p FROM Produto p, Restaurante r WHERE p.id= :produtoId and r.id=:restauranteId ")
	Optional<Produto> findByProdutoIdAndRestauranteId(@Param("produtoId") Long produtoId,@Param("restauranteId") Long restauranteId);
}
