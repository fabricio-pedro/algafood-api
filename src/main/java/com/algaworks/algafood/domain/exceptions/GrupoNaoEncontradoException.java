package com.algaworks.algafood.domain.exceptions;

public class GrupoNaoEncontradoException extends EntidadeNaoEncontradaException {

	public GrupoNaoEncontradoException(String msg) {
		super(msg);
	
	}
	public GrupoNaoEncontradoException(Long id) {
		this(String.format("Grupo com codigo: %d não encontrado", id));
	}

	private static final long serialVersionUID = 1L;

}
