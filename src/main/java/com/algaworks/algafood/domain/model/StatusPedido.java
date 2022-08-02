package com.algaworks.algafood.domain.model;

public enum StatusPedido {
	
	CRIADO("criado"),
	CONFIRMADO("confirmado"),
	ENTREGUE("entregue"),
	CANCELADO("cancelado");
	
	private String status;
	private StatusPedido(String status) {
		this.status=status;
	}

	public String getStatus() {
		return this.status;
		
	}
}
