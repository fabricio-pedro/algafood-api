package com.algaworks.algafood.domain.exceptions;

public class PermissaoNaoEncontradaException extends EntidadeNaoEncontradaException {

	public PermissaoNaoEncontradaException(String msg) {
		super(msg);
	
	}
	public PermissaoNaoEncontradaException(Long id) {
		this(String.format("Permissao com codigo %d não encontrada", id));
	}

	private static final long serialVersionUID = 1L;

}
