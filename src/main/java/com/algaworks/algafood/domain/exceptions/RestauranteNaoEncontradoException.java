package com.algaworks.algafood.domain.exceptions;

public class RestauranteNaoEncontradoException extends EntidadeNaoEncontradaException {

	public RestauranteNaoEncontradoException(String msg) {
		super(msg);
		// TODO Auto-generated constructor stub
	}
	public RestauranteNaoEncontradoException(Long id) {
		this(String.format("Restaurante com codigo: %d não encontrado",id));
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
