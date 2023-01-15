package com.algaworks.algafood.api.io.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoRes {
	
	private String codigo;
	
    private BigDecimal subTotal;
    
   
    private BigDecimal taxaFrete;
    
    private BigDecimal valorTotal;
    
    private OffsetDateTime  dataCriacao;
    
  
    private OffsetDateTime dataConfirmacao;
    
    private OffsetDateTime dataCancelamento;
    
    private OffsetDateTime dataEntrega;
    
    private String status;
    
   
    private EnderecoModelRes enderecoEntrega;
  
    
    private UsuarioRes cliente;
    
    private RestauranteModelRes restaurante;
  
    private FormaPagamentoRes formaPagamento;
    
   
    private List<ItemPedidoRes> itens=new ArrayList<>();
    
}
