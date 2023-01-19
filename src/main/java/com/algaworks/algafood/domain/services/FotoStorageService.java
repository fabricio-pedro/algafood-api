package com.algaworks.algafood.domain.services;

import java.io.InputStream;
import java.util.UUID;

import lombok.Builder;
import lombok.Getter;

public interface FotoStorageService {
   void armazenar(NovaFoto novaFoto);
   
   default String  gerarNomeArquivo(String nomeOriginal) {
	   return UUID.randomUUID().toString()+ "_" + nomeOriginal; 
   }
   
   @Getter
   @Builder
   class NovaFoto{
	 private String nome;
	 private InputStream inputStream;
   }
}
