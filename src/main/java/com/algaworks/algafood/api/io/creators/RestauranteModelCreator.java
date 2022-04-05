package com.algaworks.algafood.api.io.creators;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.api.io.model.RestauranteReq;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.Restaurante;

@Component
public class RestauranteModelCreator {
	
    @Autowired
	private ModelMapper mapper;
	
    public Restaurante toModelObject(RestauranteReq restauranteReq) {
    	return this.mapper.map(restauranteReq, Restaurante.class);
    }
    public void copyToDomainObject(RestauranteReq restauranteReq,Restaurante restaurante) {
    	 restaurante.setCozinha(new Cozinha());
    	 this.mapper.map(restauranteReq, restaurante);
    }
    
}
