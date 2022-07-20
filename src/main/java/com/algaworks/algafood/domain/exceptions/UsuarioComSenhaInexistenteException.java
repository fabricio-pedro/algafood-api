package com.algaworks.algafood.domain.exceptions;

public class UsuarioComSenhaInexistenteException extends EntidadeNaoEncontradaException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UsuarioComSenhaInexistenteException(String senha) {
		super(String.format("Usuario com senha: %s não existe", senha));
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
