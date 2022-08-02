package com.algaworks.algafood.api.io.model;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;



import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestauranteReq {
	
	
	@NotBlank
	private String nome;
	@PositiveOrZero
	@NotNull
	private BigDecimal taxaFrete;
	@Valid
	@NotNull
	private CozinhaIdReq cozinha;
	@Valid
	@NotNull
	private EnderecoReq endereco;
}
