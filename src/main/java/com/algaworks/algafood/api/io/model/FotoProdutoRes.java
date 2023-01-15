package com.algaworks.algafood.api.io.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FotoProdutoRes {
    
	private String nomeArquivo;
	
	private String descricao;
   
	private String contentType;
	
	private Long tamanho;
}
