package com.algaworks.algafood.configurations;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.algaworks.algafood.api.io.model.EnderecoModelRes;
import com.algaworks.algafood.api.io.model.ItemPedidoReq;
import com.algaworks.algafood.domain.model.Endereco;
import com.algaworks.algafood.domain.model.ItemPedido;

@Configuration
public class CustomConfig {

 @Bean	
 public ModelMapper getMapper() {
	 var mapper=new ModelMapper();
	 var enderecoToEnderecoModelResTypeMap=mapper.createTypeMap(Endereco.class,EnderecoModelRes.class);
	  enderecoToEnderecoModelResTypeMap.<String>addMapping
       	  (
			(enderecoSrc)->enderecoSrc.getCidade().getEstado().getNome(),
			(enderecoModelDest,value)-> enderecoModelDest.getCidade().setEstado(value)
		  ); 
	  
	  mapper.createTypeMap(ItemPedidoReq.class,ItemPedido.class)
	  .addMappings(mappers->mappers.skip(ItemPedido::setId));
    
	     
	  return mapper;
 }

	
}
