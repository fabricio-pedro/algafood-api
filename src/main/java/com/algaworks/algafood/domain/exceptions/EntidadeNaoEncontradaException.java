package com.algaworks.algafood.domain.exceptions;

public abstract class EntidadeNaoEncontradaException extends NegocioException{

	private static final long serialVersionUID = -1445041726905659390L;
    
	public EntidadeNaoEncontradaException(String msg) {
		super(msg);
	}
}
