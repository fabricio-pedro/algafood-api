package com.algaworks.algafood.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class FormaPagamento {

 @Id @EqualsAndHashCode.Include
 @GeneratedValue(strategy = GenerationType.AUTO)
 private Long id;
 @Column(length = 120,nullable = false)
 private String descricao;
	
}
