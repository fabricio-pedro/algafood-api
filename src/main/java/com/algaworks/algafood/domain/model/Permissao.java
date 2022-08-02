package com.algaworks.algafood.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;
@Data
@EqualsAndHashCode
@Entity
public class Permissao {
 @EqualsAndHashCode.Include
 @Id @GeneratedValue(strategy = GenerationType.IDENTITY)	
 private Long id;
 @Column(length = 100,nullable = false)	
 private String nome;
 @Column(length = 100,nullable = false)	
 private String descricao;

	
}
