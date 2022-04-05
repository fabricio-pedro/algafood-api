package com.algaworks.algafood.api.io.creators;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.api.io.model.CozinhaRes;
import com.algaworks.algafood.domain.model.Cozinha;

@Component
public class CozinhaResCreator {

 @Autowired	
 private ModelMapper mapper;
 
 public CozinhaRes toModelRes(Cozinha cozinha){
	 return this.mapper.map(cozinha, CozinhaRes.class);
	 
 }
 public List<CozinhaRes> toListModelRes(List<Cozinha> cozinhas){
	 
	 var cozinhasRes=cozinhas.stream().map(c->mapper.map(c, CozinhaRes.class))
			                         .toList();
	 return cozinhasRes; 
	 }
	
}
