package com.algaworks.algafood.api.io.creators;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.api.io.model.UsuarioReq;
import com.algaworks.algafood.domain.model.Usuario;

@Component
public class UsuarioModelCreator {
	
    @Autowired
	private ModelMapper mapper;
	
    public Usuario toModelObject(UsuarioReq UsuarioReq) {
    	return this.mapper.map(UsuarioReq, Usuario.class);
    }
    public void copyToDomainObject(UsuarioReq usuarioReq,Usuario usuario) {
    	
       	 this.mapper.map(usuarioReq, usuario);
    }
    
}
