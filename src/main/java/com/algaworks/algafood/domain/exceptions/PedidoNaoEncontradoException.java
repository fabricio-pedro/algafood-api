package com.algaworks.algafood.domain.exceptions;

public class PedidoNaoEncontradoException extends EntidadeNaoEncontradaException {

	public PedidoNaoEncontradoException(String codigo) {
		super(String.format("Pedido com codigo %s não foi encontrado", codigo));
		// TODO Auto-generated constructor stub
	}
  
	
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
