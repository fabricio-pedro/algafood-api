package com.algaworks.algafood.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algafood.domain.exceptions.PedidoNaoEncontradoException;
import com.algaworks.algafood.domain.model.Pedido;
import com.algaworks.algafood.domain.repositories.PedidoRepository;
import com.algaworks.algafood.domain.repositories.filters.PedidoFilter;
import com.algaworks.algafood.infrastructure.repository.spec.PedidoSpecs;

@Service
public class GerenciadorDePedidosService {
   
	@Autowired
	private EmissorDePedidoService emissorDePedidoService;
   
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Transactional
	public void confirmar(String codigo) {
		var pedidoAConfirmar=this.emissorDePedidoService.buscar(codigo);
		  pedidoAConfirmar.confirmar();
		 
		
		
	}
	
	public List<Pedido> pesquisarPor(PedidoFilter filtro){
		return this.pedidoRepository.findAll(PedidoSpecs.usandoFiltro(filtro));
	}
	
	@Transactional
	public void cancelar(String codigo) {
		var pedidoACancelar=this.emissorDePedidoService.buscar(codigo);
	     pedidoACancelar.cancelar();		
 }
	@Transactional
	public void entregar(String codigo) {
		var pedidoACancelar=this.emissorDePedidoService.buscar(codigo);
	     pedidoACancelar.entregar();		
 }
	
	public Pedido buscarPor(String codigo) {
		var pedidoEncontrado=this.pedidoRepository.findByCodigo(codigo);
		return pedidoEncontrado.orElseThrow(()-> new PedidoNaoEncontradoException(codigo));
	}
 	

}
