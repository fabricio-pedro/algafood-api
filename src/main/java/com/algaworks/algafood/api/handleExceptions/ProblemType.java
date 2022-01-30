package com.algaworks.algafood.api.handleExceptions;

import lombok.Getter;

@Getter
public enum ProblemType {
	RECURSO_NAO_ENCONTRADO("/recurso_nao_encontrado","Recurso não encontrado"),
	ENTIDADE_EM_USO("/entidade_em_uso","Entidade em uso"),
	ERRO_DE_NEGOCIO("/erro_de_negocio","Erro de negocio"),
	ERRO_FORMATO_INCOMPREENSIVEL("/erro_formato_incompreensivel","mensagem incompreensivel"),
	PARAMETRO_INVALIDO("/parametro_invalido","paramentro inválido"),
	DADOS_INVALIDOS("/dados_invalidos","Dados inválidos");
	private String type;
	private String title;
	ProblemType(String path, String title) {
		this.type="https://algafood.com.br"+path;
		this.title=title;
		
	}

}
