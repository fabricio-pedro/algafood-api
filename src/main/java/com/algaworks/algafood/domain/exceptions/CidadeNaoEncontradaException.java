package com.algaworks.algafood.domain.exceptions;

public class CidadeNaoEncontradaException extends EntidadeNaoEncontradaException {

	public CidadeNaoEncontradaException(String msg) {
		super(msg);
	
	}
	public CidadeNaoEncontradaException(Long id) {
		this(String.format("Cidade com codigo: %d não encontrada", id));
	}

	private static final long serialVersionUID = 1L;

}
