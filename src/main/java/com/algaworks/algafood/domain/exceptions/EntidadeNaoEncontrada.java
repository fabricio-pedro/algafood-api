package com.algaworks.algafood.domain.exceptions;

public class EntidadeNaoEncontrada extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1445041726905659390L;
    
	public EntidadeNaoEncontrada(String msg) {
		super(msg);
	}
}
