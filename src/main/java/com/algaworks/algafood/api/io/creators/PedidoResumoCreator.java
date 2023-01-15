package com.algaworks.algafood.api.io.creators;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.api.io.model.PedidoRes;
import com.algaworks.algafood.api.io.model.PedidoResumoModel;
import com.algaworks.algafood.domain.model.Pedido;

@Component
public class PedidoResumoCreator {

 @Autowired	
 private ModelMapper mapper;
 
 public PedidoResumoModel toModelRes(Pedido pedido){
	 return this.mapper.map(pedido, PedidoResumoModel.class);
	 
 }
 public List<PedidoResumoModel> toListModelRes(Collection<Pedido> pedidos){
	 
	 var pedidosRes=pedidos.stream().map(pedido->toModelRes(pedido))
			                         .collect(Collectors.toList());
	 return pedidosRes; 
	 }
	
}
