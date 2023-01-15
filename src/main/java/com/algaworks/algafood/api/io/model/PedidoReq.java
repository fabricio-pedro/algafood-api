package com.algaworks.algafood.api.io.model;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PedidoReq {
	
	@Valid
	@NotNull
	private RestauranteIdReq restaurante;
	
	@Valid
	@NotNull
	private FormaPagamentoIdReq formaPagamento;
	@Valid
	@NotNull
	@Size(min = 1)
	private List<ItemPedidoReq> itens;
	
	@Valid
	@NotNull
	private EnderecoReq enderecoEntrega;

}
