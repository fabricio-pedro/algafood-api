package com.algaworks.algafood.domain.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.algaworks.algafood.core.validations.Groups;

import lombok.Data;

@Data
@Entity
public class Cozinha {

 @Id 
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @NotNull(groups = Groups.CadastroCozinhaId.class)
 private Long id;
 
 @Column(length = 100)
 @NotBlank
 private String nome;
 
 @OneToMany(mappedBy = "cozinha")
 private List<Restaurante> restaurantes=new ArrayList<>();



 

}
