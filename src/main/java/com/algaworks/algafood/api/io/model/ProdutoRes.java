package com.algaworks.algafood.api.io.model;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoRes {

  private Long id;
  
  private String nome;
  
  private String descricao;
  
  private BigDecimal preco;
  
  private boolean ativo;
	
}
