package com.algaworks.algafood.api.io.model;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EnderecoReq {

	@NotBlank
    private String cep;
	@NotBlank
	private String logradouro;
	@NotBlank
	private String numero;
	
	private String complemento;
	@NotBlank
	private String bairro;
	
	@Valid
	@NotNull
	private CidadeIdReq cidade;
	
	
	
	
}
