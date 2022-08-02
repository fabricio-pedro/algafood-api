package com.algaworks.algafood.domain.services;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algafood.domain.exceptions.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exceptions.GrupoNaoEncontradoException;
import com.algaworks.algafood.domain.model.Grupo;
import com.algaworks.algafood.domain.repositories.GrupoRepository;

@Service
public class CadastroGrupoService {

 private final GrupoRepository grupoRep;
 
 private static final String ENTIDADE_EM_USO="Grupo com código %s esta em uso e não pode ser removido";
 
 
 public CadastroGrupoService(GrupoRepository grupoRep) {
	super();
	this.grupoRep = grupoRep;
 }	
 
 @Transactional
 public Grupo salvar(Grupo grupo) {
	var grupoSalvo=this.grupoRep.save(grupo);
	return grupoSalvo;
 }
 
 public Grupo buscar(Long id) {
  var grupoOpt=this.grupoRep.findById(id);
  return grupoOpt.orElseThrow(()->new GrupoNaoEncontradoException(id));
 }
 
 @Transactional
 public void excluir(Long id) {
 try {
		this.grupoRep.deleteById(id);
	}
	catch(EmptyResultDataAccessException ex) {
		throw new GrupoNaoEncontradoException(id);
	}
	catch(DataIntegrityViolationException ex) {
	  throw new EntidadeEmUsoException(String.format(ENTIDADE_EM_USO, id));	
	}
  }
 
 
 public List<Grupo> listar(){
	 return this.grupoRep.findAll();
 }
 
}
