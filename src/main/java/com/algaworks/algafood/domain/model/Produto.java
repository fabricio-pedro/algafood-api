package com.algaworks.algafood.domain.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Produto {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @EqualsAndHashCode.Include
	private Long id;
    @Column(nullable = false)
	private String nome;
    @Column(nullable=false)
    private String descricao;
    @Column(nullable = false)
	private BigDecimal preco;
    @Column(nullable = false)
	private boolean ativo;
	@ManyToOne
	@JoinColumn(name ="restaurante_id")
	private Restaurante restaurante;
}
