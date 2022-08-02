package com.algaworks.algafood.domain.exceptions;

public class UsuarioNaoEncontradoException extends EntidadeNaoEncontradaException {

	public UsuarioNaoEncontradoException(String msg) {
		super(msg);
	
	}
	public UsuarioNaoEncontradoException(Long id) {
		this(String.format("Usuario com codigo: %d não encontrado", id));
	}

	private static final long serialVersionUID = 1L;

}
