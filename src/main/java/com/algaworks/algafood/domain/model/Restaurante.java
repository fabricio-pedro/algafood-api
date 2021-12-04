package com.algaworks.algafood.domain.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Restaurante {	
	
@Id @EqualsAndHashCode.Include 
@GeneratedValue(strategy = GenerationType.IDENTITY)	
private Long id;	
@Column(length = 150)
private String nome;
@Column(name = "taxa_frete")
private BigDecimal taxaFrete;
@ManyToOne
@JoinColumn(name = "cozinha_id",nullable = false)
private Cozinha cozinha;

@Embedded
private Endereco endereco;

@OneToMany(mappedBy = "restaurante")
private List<Produto> produtos=new ArrayList<>();

@ManyToMany
@JoinTable(name = "restaurantes_formas_pagamento",
           joinColumns = @JoinColumn(name="restaurante_id"),
           inverseJoinColumns = @JoinColumn(name="forma_pagamento_id"))
private List<FormaPagamento> formasPagamentos;

	
}
