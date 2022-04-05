package com.algaworks.algafood.api.io.creators;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.api.io.model.CidadeRes;
import com.algaworks.algafood.api.io.model.CozinhaRes;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.model.Cozinha;

@Component
public class CidadeResCreator {

 @Autowired	
 private ModelMapper mapper;
 
 public CidadeRes toModelRes(Cidade cidade){
	 return this.mapper.map(cidade, CidadeRes.class);
	 
 }
 public List<CozinhaRes> toListModelRes(List<Cozinha> cozinhas){
	 
	 var cozinhasRes=cozinhas.stream().map(c->mapper.map(c, CozinhaRes.class))
			                         .toList();
	 return cozinhasRes; 
	 }
	
}
