package com.algaworks.algafood.api.io.model;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RestauranteModelRes {
	
	private Long id;
	private String nome;
	private BigDecimal taxaFrete;
	private CozinhaRes cozinha;
	private boolean ativo;
	

	
}
