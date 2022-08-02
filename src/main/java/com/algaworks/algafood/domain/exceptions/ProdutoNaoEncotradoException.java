package com.algaworks.algafood.domain.exceptions;

public class ProdutoNaoEncotradoException extends EntidadeNaoEncontradaException {

	public ProdutoNaoEncotradoException(String msg) {
		super(msg);
		// TODO Auto-generated constructor stub
	}
  
	public ProdutoNaoEncotradoException(Long restauranteId,Long produtoId) {
		this(String.format("Produto com codigo %d não foi encontrado no restaurante com codigo %d", produtoId, restauranteId));
		
		// TODO Auto-generated constructor stub
	}
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
