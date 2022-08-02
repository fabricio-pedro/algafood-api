package com.algaworks.algafood.api.io.model;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UsuarioSenha {

 @NotBlank	
 private String senhaAtual;
 @NotBlank
 private String novaSenha;
	
}
