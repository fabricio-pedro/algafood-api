package com.algaworks.algafood.domain.exceptions;

public class FormaPagamentoNaoEncontradoException extends EntidadeNaoEncontradaException {

	public FormaPagamentoNaoEncontradoException(String msg) {
		super(msg);
		// TODO Auto-generated constructor stub
	}
	public FormaPagamentoNaoEncontradoException(Long id) {
		this(String.format("Forma de pagamento com codigo %d não encontrado", id));
	}
	
	private static final long serialVersionUID = 8372866383973521735L;

}
