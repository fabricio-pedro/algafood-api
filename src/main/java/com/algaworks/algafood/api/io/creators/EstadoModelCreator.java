package com.algaworks.algafood.api.io.creators;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.api.io.model.CozinhaReq;
import com.algaworks.algafood.api.io.model.EstadoReq;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.Estado;

@Component
public class EstadoModelCreator {
	
    @Autowired
	private ModelMapper mapper;
	
    public Estado toModelObject(EstadoReq estadoReq) {
    	return this.mapper.map(estadoReq, Estado.class);
    }
    public void copyToDomainObject(EstadoReq estadoReq,Estado estado) {
    	
       	 this.mapper.map(estadoReq, estado);
    }
    
}
