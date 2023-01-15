package com.algaworks.algafood.api.io.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FormaPagamentoIdReq {

   @NotNull	
   private Long id;
	
	
}
