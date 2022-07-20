package com.algaworks.algafood.api.controllers;

import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.api.io.creators.GrupoModelCreator;
import com.algaworks.algafood.api.io.creators.GrupoResCreator;
import com.algaworks.algafood.api.io.model.GrupoReq;
import com.algaworks.algafood.api.io.model.GrupoRes;
import com.algaworks.algafood.domain.services.CadastroGrupoService;

@RestController
@RequestMapping("/grupos")
public class GrupoController {

	@Autowired
	private GrupoResCreator grupoResCreator;
	@Autowired
	private GrupoModelCreator grupoReqCreator;
	@Autowired
	private CadastroGrupoService grupoService;
	
	@GetMapping
	public List<GrupoRes> listar(){
		var grupos=this.grupoService.listar();
		return this.grupoResCreator.toListModelRes(grupos);
		
	}
	@GetMapping("/{id}")
	public GrupoRes buscar(@PathVariable Long id) {
	   var grupo=this.grupoService.buscar(id);
	   var grupoRes=this.grupoResCreator.toModelRes(grupo);
	   return grupoRes;   
	}
	
	@PostMapping
	public GrupoRes salvar(@RequestBody @Valid GrupoReq grupoReq) {
		var grupo=this.grupoReqCreator.toModelObject(grupoReq);
		var grupoSalvo=this.grupoService.salvar(grupo);
		return this.grupoResCreator.toModelRes(grupoSalvo);
		
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long id) {
	  this.grupoService.excluir(id);	
	}
   
   @PutMapping("/{id}")
   public GrupoRes alterar(@PathVariable Long id, @RequestBody @Valid GrupoReq grupoReq ) {
	   var grupoAtual=this.grupoService.buscar(id);
	   this.grupoReqCreator.copyToDomainObject(grupoReq, grupoAtual);
	   var grupoSalvo=this.grupoService.salvar(grupoAtual);
	   return this.grupoResCreator.toModelRes(grupoSalvo); 
   }
   
	
	
	
	
}
