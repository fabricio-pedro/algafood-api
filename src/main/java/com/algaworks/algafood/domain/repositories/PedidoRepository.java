package com.algaworks.algafood.domain.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.algaworks.algafood.domain.model.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>,JpaSpecificationExecutor<Pedido> {

	@Query("FROM Pedido p join fetch p.cliente join fetch p.restaurante r")
	public List<Pedido> findAll();
	
	public Optional<Pedido> findByCodigo(String codigo);
}
