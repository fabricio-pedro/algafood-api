package com.algaworks.algafood.domain.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Grupo {
    @Id  @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    @Column(nullable = false)
	private String nome;
	
    @ManyToMany
    @JoinTable(name="grupo_permissao",
    		joinColumns = @JoinColumn(name="grupo_id"),
    		inverseJoinColumns = @JoinColumn(name="permissao_id")
    		)
    private Set<Permissao> permissoes=new HashSet<>();
    
    public void adicionarPermissao(Permissao permissao) {
    	this.permissoes.add(permissao);
    }
    public void removerPermissao(Permissao permissao) {
    	this.permissoes.remove(permissao);
    }
	
	
}
