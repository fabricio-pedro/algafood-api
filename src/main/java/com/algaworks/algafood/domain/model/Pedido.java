package com.algaworks.algafood.domain.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;

import org.hibernate.annotations.CreationTimestamp;

import com.algaworks.algafood.domain.exceptions.NegocioException;

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
	
	
	private String codigo;
	
	@Column(name = "sub_total")
    private BigDecimal subTotal;
    
    @Column(nullable = false)
    private BigDecimal taxaFrete;
    
    private BigDecimal valorTotal;
    @CreationTimestamp
    private OffsetDateTime  dataCriacao;
    
    @Column(nullable = false)
    @CreationTimestamp
    private OffsetDateTime dataConfirmacao;
    
    private OffsetDateTime dataCancelamento;
    @Column(nullable = false)
    @CreationTimestamp
    private OffsetDateTime dataEntrega;
    @Enumerated(EnumType.STRING)
    private StatusPedido status=StatusPedido.CRIADO;
    
    @Embedded
    private Endereco enderecoEntrega;
    
    @ManyToOne
    @JoinColumn(name="usuario_cliente_id" ,nullable = false)
    private Usuario cliente;
    
    @ManyToOne
	@JoinColumn(nullable = false)
	private Restaurante restaurante;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private FormaPagamento formaPagamento;
    
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private Set<ItemPedido> itens=new HashSet<>();
    
	public void calcularTotal() {
          getItens().forEach(ItemPedido::calcularPrecoTotal);
		
		     this.subTotal = getItens().stream()
			.map(item -> item.getPrecoTotal())
			.reduce(BigDecimal.ZERO, BigDecimal::add);
		
		    this.valorTotal = this.subTotal.add(this.taxaFrete);
	}
	public void definirFrete() {
	    setTaxaFrete(getRestaurante().getTaxaFrete());
	}

	public void atribuirPedidoAosItens() {
	    getItens().forEach(item -> item.setPedido(this));
	}
	
	public void confirmar() {
		setStatus(StatusPedido.CONFIRMADO);
		setDataConfirmacao(OffsetDateTime.now());
	}
	public void cancelar() {
		setStatus(StatusPedido.CANCELADO);
		setDataCancelamento(OffsetDateTime.now());
	}
	public void entregar() {
		setStatus(StatusPedido.ENTREGUE);
		setDataEntrega(OffsetDateTime.now());
	}
	private void setStatus(StatusPedido novoStatus) {
		 if(this.status.naoPodeAlterarPara(novoStatus)) {
			 throw new NegocioException(String.format("Status do pedido %d não pode ser alterado de %s para %s",
						this.getId(), this.getStatus().getDescricao(), 
						novoStatus.getDescricao()));
		 }
		 this.status=novoStatus;
	}
	
	@PrePersist
	private void gerarCodigo() {
		setCodigo(UUID.randomUUID().toString());
	}
    
    
}
