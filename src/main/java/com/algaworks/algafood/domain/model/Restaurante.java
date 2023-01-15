package com.algaworks.algafood.domain.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.algaworks.algafood.core.validations.Groups.CadastroCozinhaId;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Restaurante {

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotBlank
	@Column(length = 150)
	private String nome;
	@PositiveOrZero
	@Column(name = "taxa_frete")
	private BigDecimal taxaFrete;
    
	@Column
	private boolean ativo=true;
	
	@Column
	private boolean aberto;
	
	@UpdateTimestamp
	@Column(nullable = false, columnDefinition = "datetime")
	private OffsetDateTime dataAtualizacao;
	
	
	@CreationTimestamp
	@Column(nullable = false, columnDefinition = "datetime")
	private OffsetDateTime dataCadastro;
   
	@NotNull
    @Valid
    @ConvertGroup(from=Default.class, to=CadastroCozinhaId.class)
	@ManyToOne
	@JoinColumn(name = "cozinha_id", nullable = false)
	private Cozinha cozinha;

	@Embedded
	private Endereco endereco;

	@OneToMany(mappedBy = "restaurante")
	private List<Produto> produtos = new ArrayList<>();

	
	  @ManyToMany
      @JoinTable(name = "restaurante_forma_pagamento", 
	   joinColumns= @JoinColumn(name="restaurante_id"), 
	   inverseJoinColumns = @JoinColumn(name="forma_pagamento_id")) 
    private Set<FormaPagamento>  formasPagamentos=new HashSet<>();
	
	  @ManyToMany
      @JoinTable(name = "restaurante_responsavel", 
	   joinColumns= @JoinColumn(name="restaurante_id"), 
	   inverseJoinColumns = @JoinColumn(name="usuario_id")) 
    private Set<Usuario>  responsaveis=new HashSet<>();
	
	  
	  
   public void ativar() {
		setAtivo(true);
	}
   
   public void inativar() {
		setAtivo(false);
   }
   
   public void abrir() {
	   setAberto(true);
   }
   
   public void fechar() {
	   setAberto(false);
   }
   
   public boolean addicionarFormaPagamento(FormaPagamento formaPg) {
	   return this.formasPagamentos.add(formaPg);
   }
   public boolean removerFormaPagamento(FormaPagamento formaPg) {
	   return this.formasPagamentos.remove(formaPg);
   }
   
   public boolean adicionarResponsavel(Usuario responsavel) {
	   return this.responsaveis.add(responsavel);
   }
   public boolean removerResponsavel(Usuario responsavel) {
	   return this.responsaveis.remove(responsavel);
   }
   public boolean naoAceitaFormaDePagamento(FormaPagamento formaPg) {
	   return !this.formasPagamentos.contains(formaPg);
   }

}
