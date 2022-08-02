package com.algaworks.algafood.api.io.creators;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.api.io.model.UsuarioRes;
import com.algaworks.algafood.domain.model.Usuario;

@Component
public class UsuarioResCreator {

 @Autowired	
 private ModelMapper mapper;
 
 public UsuarioRes toModelRes(Usuario Usuario){
	 return this.mapper.map(Usuario, UsuarioRes.class);
	 
 }
 public List<UsuarioRes> toListModelRes(List<Usuario> Usuarios){
	 
	 var UsuariosRes=Usuarios.stream().map(u->toModelRes(u))
			                          .collect(Collectors.toList());
	 return UsuariosRes; 
	 }
	
}
