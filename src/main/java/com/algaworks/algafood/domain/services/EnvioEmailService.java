package com.algaworks.algafood.domain.services;

import java.util.Set;

import lombok.Builder;
import lombok.Getter;
import lombok.Singular;

public interface EnvioEmailService {
	
	void enviar(Messagem msg);
	
	@Getter
	@Builder
	class Messagem{
     @Singular		
     private Set<String> destinarios;
     private String assunto;
     private String corpo;
	}
	

}
