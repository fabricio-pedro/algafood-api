package com.algaworks.algafood.domain.exceptions;

public class FotoNaoEncontradaException extends EntidadeNaoEncontradaException {

	public FotoNaoEncontradaException(String msg) {
		super(msg);
	
	}
	public FotoNaoEncontradaException(Long restauranteId,Long produtoId) {
		 this(String.format("Não existe um cadastro de foto do produto com código %d para o restaurante de código %d",
	                produtoId, restauranteId));
	}

	private static final long serialVersionUID = 1L;

}
