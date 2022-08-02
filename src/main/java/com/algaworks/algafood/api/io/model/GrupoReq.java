package com.algaworks.algafood.api.io.model;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GrupoReq {

@NotBlank	
private String nome;
	
}
