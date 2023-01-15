package com.algaworks.algafood.api.io.creators;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.api.io.model.PedidoReq;
import com.algaworks.algafood.domain.model.Pedido;

@Component
public class PedidoModelCreator {
	
    @Autowired
	private ModelMapper mapper;
	
    public Pedido toModelObject(PedidoReq pedidoReq) {
    	return this.mapper.map(pedidoReq, Pedido.class);
    }
    public void copyToDomainObject(PedidoReq pedidoReq,Pedido pedido) {
    	
       	 this.mapper.map(pedidoReq, pedido);
    }
    
}
