package com.algaworks.algafood.domain.services;

import java.io.InputStream;
import java.util.UUID;

import lombok.Builder;
import lombok.Getter;

public interface FotoStorageService {
   void armazenar(NovaFoto novaFoto);
   
   void remover(String antigaFoto);
   InputStream recuperar (String arquivo);
   default String  gerarNomeArquivo(String nomeOriginal) {
	   return UUID.randomUUID().toString()+ "_" + nomeOriginal; 
   }
   default void substituir(String nomeArquivoAntigo, NovaFoto novaFoto) {
		this.armazenar(novaFoto);
		
		if (nomeArquivoAntigo != null) {
			this.remover(nomeArquivoAntigo);
		}
	}
   
   @Getter
   @Builder
   class NovaFoto{
	 private String nome;
	 private InputStream inputStream;
   }
}
