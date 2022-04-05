package com.algaworks.algafood.api.io.model;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CidadeReq {
	
	@NotBlank
	private String nome;
	@Valid
	@NotNull
	private EstadoIdReq estado;
}
