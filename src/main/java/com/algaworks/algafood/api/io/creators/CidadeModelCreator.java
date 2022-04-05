package com.algaworks.algafood.api.io.creators;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.api.io.model.CidadeReq;
import com.algaworks.algafood.api.io.model.CozinhaReq;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.model.Cozinha;

@Component
public class CidadeModelCreator {
	
    @Autowired
	private ModelMapper mapper;
	
    public Cidade toModelObject(CidadeReq cidadeReq) {
    	return this.mapper.map(cidadeReq, Cidade.class);
    }
    public void copyToDomainObject(CidadeReq cidadeReq,Cidade cidade) {
    	
       	 this.mapper.map(cidadeReq, cidade);
    }
    
}
