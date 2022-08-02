package com.algaworks.algafood.api.io.creators;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.api.io.model.EstadoRes;
import com.algaworks.algafood.domain.model.Estado;

@Component
public class EstadoResCreator {

 @Autowired	
 private ModelMapper mapper;
 
 public EstadoRes toModelRes(Estado estado){
	 return this.mapper.map(estado, EstadoRes.class);
	 
 }
 public List<EstadoRes> toListModelRes(List<Estado> estados){
	 
	 var estadosRes=estados.stream().map(e->toModelRes(e))
			                         .collect(Collectors.toList());
	 return estadosRes; 
	 }
	
}
