package com.algaworks.algafood.api.io.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class PedidoResumoModel {
    private String codigo;	
    private BigDecimal subTotal;
    private BigDecimal taxaFrete; 
    private BigDecimal valorTotal; 
    private OffsetDateTime  dataCriacao;
    private String status;
    private UsuarioRes cliente;
    private RestauranteResumoModel restaurante;
 
}
