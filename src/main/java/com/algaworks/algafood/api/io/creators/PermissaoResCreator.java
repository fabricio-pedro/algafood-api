package com.algaworks.algafood.api.io.creators;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.api.io.model.PermissaoRes;
import com.algaworks.algafood.domain.model.Permissao;

@Component
public class PermissaoResCreator {

 @Autowired	
 private ModelMapper mapper;
 
 public PermissaoRes toModelRes(Permissao permissao){
	 return this.mapper.map(permissao, PermissaoRes.class);
	 
 }
 public List<PermissaoRes> toListModelRes(Collection<Permissao> permissoes ){
	 
	 var permissoesRes=permissoes.stream().map(permissao->toModelRes(permissao)).collect(Collectors.toList());
	 return permissoesRes; 
	 }
	
}
