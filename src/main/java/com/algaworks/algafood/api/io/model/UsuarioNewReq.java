package com.algaworks.algafood.api.io.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UsuarioNewReq extends UsuarioReq {
    
	@NotBlank
	@Size(min = 5,max = 25)
	private String senha;
}
