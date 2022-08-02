package com.algaworks.algafood.api.io.creators;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.api.io.model.ProdutoReq;
import com.algaworks.algafood.domain.model.Produto;

@Component
public class ProdutoModelCreator {
	
    @Autowired
	private ModelMapper mapper;
	
    public Produto toModelObject(ProdutoReq ProdutoReq) {
    	return this.mapper.map(ProdutoReq, Produto.class);
    }
    public void copyToDomainObject(ProdutoReq ProdutoReq,Produto Produto) {
    	
       	 this.mapper.map(ProdutoReq, Produto);
    }
    
}
