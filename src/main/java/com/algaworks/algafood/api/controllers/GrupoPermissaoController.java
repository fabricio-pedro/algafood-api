package com.algaworks.algafood.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.api.io.creators.PermissaoResCreator;
import com.algaworks.algafood.api.io.model.PermissaoRes;
import com.algaworks.algafood.domain.services.CadastroGrupoService;

@RestController
@RequestMapping("/grupos/{id}/permissoes")
public class GrupoPermissaoController {
 
 @Autowired
 private CadastroGrupoService grupoService;
 
 @Autowired
 private PermissaoResCreator permissaoResCreator;

 @GetMapping
 public List<PermissaoRes> listar(@PathVariable("id") Long grupoId){
    var grupoEncontrado= this.grupoService.buscar(grupoId);
	var permissoesRes= this.permissaoResCreator
			               .toListModelRes(grupoEncontrado.getPermissoes());
  return permissoesRes;
 }
 
 @PutMapping("/{permissaoId}")
 @ResponseStatus(value = HttpStatus.NO_CONTENT)
 public void associar(@PathVariable("id") Long grupoId,@PathVariable  Long permissaoId) {
	 this.grupoService.associarPermissao(grupoId, permissaoId);
 }
 @DeleteMapping("/{permissaoId}")
 @ResponseStatus(value = HttpStatus.NO_CONTENT)
 public void desassociar(@PathVariable("id") Long grupoId,@PathVariable  Long permissaoId) {
	 this.grupoService.dessociarPermissao(grupoId, permissaoId);
 }	
}
