package com.algaworks.algafood.domain.services;

import java.util.Map;
import java.util.Set;

import lombok.Builder;
import lombok.Getter;
import lombok.Singular;

public interface EnvioEmailService {
	
	void enviar(Mensagem msg);
	
	@Getter
	@Builder
	class Mensagem{
     @Singular		
     private Set<String> destinarios;
     private String assunto;
     private String corpo;
     @Singular(value = "variavel")
     private Map<String, Object> variaveis;
	}
	

}
