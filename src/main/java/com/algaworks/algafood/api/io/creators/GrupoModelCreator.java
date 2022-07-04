package com.algaworks.algafood.api.io.creators;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.api.io.model.EstadoReq;
import com.algaworks.algafood.api.io.model.GrupoReq;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.model.Grupo;

@Component
public class GrupoModelCreator {
	
    @Autowired
	private ModelMapper mapper;
	
    public Grupo toModelObject(GrupoReq grupoReq) {
    	return this.mapper.map(grupoReq, Grupo.class);
    }
    public void copyToDomainObject(GrupoReq grupoReq,Grupo grupo) {
    	
       	 this.mapper.map(grupoReq, grupo);
    }
    
}
