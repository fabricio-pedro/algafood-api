package com.algaworks.algafood.api.io.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EnderecoModelRes {

	private String cep;
	
	private String logradouro;

	private String numero;
	
	private String complemento;
	
	private String bairro;
	
	private CidadeResumoRes cidade;
}
