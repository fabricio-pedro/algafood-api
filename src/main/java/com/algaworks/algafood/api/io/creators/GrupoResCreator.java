package com.algaworks.algafood.api.io.creators;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.api.io.model.EstadoRes;
import com.algaworks.algafood.api.io.model.GrupoRes;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.model.Grupo;

@Component
public class GrupoResCreator {

 @Autowired	
 private ModelMapper mapper;
 
 public GrupoRes toModelRes(Grupo grupo){
	 return this.mapper.map(grupo, GrupoRes.class);
	 
 }
 public List<GrupoRes> toListModelRes(List<Grupo> grupos){
	 
	 var gruposRes=grupos.stream().map(grupo->toModelRes(grupo))
			                         .collect(Collectors.toList());
	 return gruposRes; 
	 }
	
}
