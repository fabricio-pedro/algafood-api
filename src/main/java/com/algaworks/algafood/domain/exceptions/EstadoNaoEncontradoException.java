package com.algaworks.algafood.domain.exceptions;

public class EstadoNaoEncontradoException extends EntidadeNaoEncontradaException {

	public EstadoNaoEncontradoException(String msg) {
		super(msg);
		
	}
	
	public EstadoNaoEncontradoException(Long id) {
		this(String.format("Estado com codigo:%d não encontrado", id));
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
