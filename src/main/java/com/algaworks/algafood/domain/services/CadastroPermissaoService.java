package com.algaworks.algafood.domain.services;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algafood.domain.exceptions.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exceptions.PermissaoNaoEncontradaException;
import com.algaworks.algafood.domain.model.Permissao;
import com.algaworks.algafood.domain.repositories.PermissaoRepository;

@Service
public class CadastroPermissaoService {

 private final PermissaoRepository PermissaoRep;
 
 private static final String ENTIDADE_EM_USO="Permissao com código %s esta em uso e não pode ser removido";
 
 
 public CadastroPermissaoService(PermissaoRepository PermissaoRep) {
	super();
	this.PermissaoRep = PermissaoRep;
 }	
 
 @Transactional
 public Permissao salvar(Permissao Permissao) {
	var PermissaoSalvo=this.PermissaoRep.save(Permissao);
	return PermissaoSalvo;
 }
 
 public Permissao buscar(Long id) {
  var PermissaoOpt=this.PermissaoRep.findById(id);
  return PermissaoOpt.orElseThrow(()->new PermissaoNaoEncontradaException(id));
 }
 
 @Transactional
 public void excluir(Long id) {
 try {
		this.PermissaoRep.deleteById(id);
	}
	catch(EmptyResultDataAccessException ex) {
		throw new PermissaoNaoEncontradaException(id);
	}
	catch(DataIntegrityViolationException ex) {
	  throw new EntidadeEmUsoException(String.format(ENTIDADE_EM_USO, id));	
	}
  }
 
 public List<Permissao> listar(){
	 return this.PermissaoRep.findAll();
 }
 
}
