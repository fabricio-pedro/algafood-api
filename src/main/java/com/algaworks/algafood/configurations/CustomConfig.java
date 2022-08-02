package com.algaworks.algafood.configurations;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.algaworks.algafood.api.io.model.EnderencoModelRes;
import com.algaworks.algafood.api.io.model.ProdutoReq;
import com.algaworks.algafood.domain.model.Endereco;
import com.algaworks.algafood.domain.model.Produto;

@Configuration
public class CustomConfig {

 @Bean	
 public ModelMapper getMapper() {
	 var mapper=new ModelMapper();
	 var enderecoToEnderecoModelResTypeMap=mapper.createTypeMap(Endereco.class,EnderencoModelRes.class);
	  enderecoToEnderecoModelResTypeMap.<String>addMapping
       	  (
			(enderecoSrc)->enderecoSrc.getCidade().getEstado().getNome(),
			(enderecoModelDest,value)-> enderecoModelDest.getCidade().setEstado(value)
		  ); 
    
	     
	  return mapper;
 }
	
}
