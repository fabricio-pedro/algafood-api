package com.algaworks.algafood.api.io.creators;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.api.io.model.PedidoRes;
import com.algaworks.algafood.domain.model.Pedido;

@Component
public class PedidoResCreator {

 @Autowired	
 private ModelMapper mapper;
 
 public PedidoRes toModelRes(Pedido pedido){
	 return this.mapper.map(pedido, PedidoRes.class);
	 
 }
 public List<PedidoRes> toListModelRes(Collection<Pedido> pedidos){
	 
	 var pedidosRes=pedidos.stream().map(pedido->toModelRes(pedido))
			                         .collect(Collectors.toList());
	 return pedidosRes; 
	 }
	
}
