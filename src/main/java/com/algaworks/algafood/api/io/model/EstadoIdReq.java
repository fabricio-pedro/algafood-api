package com.algaworks.algafood.api.io.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstadoIdReq {

   @NotNull	
   private Long id;
	
	
}
