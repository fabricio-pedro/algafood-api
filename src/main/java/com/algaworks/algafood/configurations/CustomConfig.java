package com.algaworks.algafood.configurations;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomConfig {

 @Bean	
 public ModelMapper getMapper() {
	 var mapper=new ModelMapper();
	 return mapper;
 }
	
}
