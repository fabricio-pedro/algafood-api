package com.algaworks.algafood.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Pedido {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	
    private BigDecimal subTotal;
    
    @Column(nullable = false)
    private BigDecimal taxaFrete;
    
    private BigDecimal valorTotal;
    @CreationTimestamp
    private LocalDateTime  dataCriacao;
    
    @Column(nullable = false)
    private LocalDateTime dataConfirmacao;
    
    private LocalDateTime dataCancelamento;
    @Column(nullable = false)
    private LocalDateTime dataEntrega;
    @Enumerated(EnumType.STRING)
    private StatusPedido status;
    
    @Embedded
    private Endereco enderecoEntrega;
    
    @ManyToOne
    @JoinColumn(name="usuario_cliente_id" ,nullable = false)
    private Usuario usuario;
    
    
    @ManyToOne
    @JoinColumn(nullable = false)
    private FormaPagamento formaPagamento;
    
    @OneToMany(mappedBy = "pedido")
    private List<ItemPedido> itens=new ArrayList<>();
    
	
}
