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
import com.algaworks.algafood.domain.services.EnvioEmailService.Messagem;

@Service
public class GerenciadorDePedidosService {
   
	@Autowired
	private EmissorDePedidoService emissorDePedidoService;
   
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
    private	EnvioEmailService emailService;
	
	@Transactional
	public void confirmar(String codigo) {
		var pedidoAConfirmar=this.emissorDePedidoService.buscar(codigo);
		    pedidoAConfirmar.confirmar();
		    var msg=Messagem.builder()
		    		.assunto(pedidoAConfirmar.getRestaurante().getNome() + " - Pedido confirmado")
					.corpo("O pedido de código <strong>" 
							+ pedidoAConfirmar.getCodigo() + "</strong> foi confirmado!")
					.destinario(pedidoAConfirmar.getCliente().getEmail())
					.build();
		    this.emailService.enviar(msg);
		    
		 
		
		
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
