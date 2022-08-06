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
 
 private final CadastroPermissaoService permissaoService;
 
 public CadastroGrupoService(GrupoRepository grupoRep, CadastroPermissaoService permissaoService) {
	super();
	this.grupoRep = grupoRep;
	this.permissaoService=permissaoService;
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
 
 @Transactional
 public void associarPermissao(Long grupoId, Long permissaoId) {
	 var grupoEncontrado=this.buscar(grupoId);
	 var permissaoEncontrada=this.permissaoService.buscar(permissaoId);
	 grupoEncontrado.adicionarPermissao(permissaoEncontrada);
	 
 }
 @Transactional
 public void dessociarPermissao(Long grupoId, Long permissaoId) {
	 var grupoEncontrado=this.buscar(grupoId);
	 var permissaoEncontrada=this.permissaoService.buscar(permissaoId);
	 grupoEncontrado.removerPermissao(permissaoEncontrada);
	 
 }
 
 
}
