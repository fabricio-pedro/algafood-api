package com.algaworks.algafood.api.io.model;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EstadoReq {
    
	@NotBlank
	private String nome;
}
