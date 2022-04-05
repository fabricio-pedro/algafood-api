package com.algaworks.algafood.api.io.creators;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.api.io.model.CozinhaReq;
import com.algaworks.algafood.api.io.model.RestauranteReq;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.Restaurante;

@Component
public class CozinhaModelCreator {
	
    @Autowired
	private ModelMapper mapper;
	
    public Cozinha toModelObject(CozinhaReq cozinhaReq) {
    	return this.mapper.map(cozinhaReq, Cozinha.class);
    }
    public void copyToDomainObject(CozinhaReq cozinhaReq,Cozinha cozinha) {
    	
       	 this.mapper.map(cozinhaReq, cozinha);
    }
    
}
