package com.algaworks.algafood.domain.exceptions;

public class CozinhaNaoEncotradaException extends EntidadeNaoEncontradaException {

	public CozinhaNaoEncotradaException(String msg) {
		super(msg);
		// TODO Auto-generated constructor stub
	}
  
	public CozinhaNaoEncotradaException(Long id) {
		this(String.format("Cozinha com codigo: %d não encontrada", id));
		
		// TODO Auto-generated constructor stub
	}
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
