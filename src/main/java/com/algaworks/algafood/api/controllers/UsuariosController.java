package com.algaworks.algafood.api.controllers;

import java.util.List;

import javax.validation.Valid;

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

import com.algaworks.algafood.api.io.creators.UsuarioModelCreator;
import com.algaworks.algafood.api.io.creators.UsuarioResCreator;
import com.algaworks.algafood.api.io.model.UsuarioNewReq;
import com.algaworks.algafood.api.io.model.UsuarioReq;
import com.algaworks.algafood.api.io.model.UsuarioRes;
import com.algaworks.algafood.api.io.model.UsuarioSenha;
import com.algaworks.algafood.domain.services.CadastroUsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

 @Autowired	
 private CadastroUsuarioService usuarioService;	
 @Autowired
 private UsuarioModelCreator usuarioModelCreator;
 
 @Autowired
 private UsuarioResCreator usuarioResCreator;
 
 @PostMapping
 public UsuarioRes salvar(@RequestBody @Valid UsuarioNewReq usuarioReq) {
	  var usuario=this.usuarioModelCreator.toModelObject(usuarioReq);
	  var usuarioSalvo=this.usuarioService.salvar(usuario);
	  var usuarioRes=this.usuarioResCreator.toModelRes(usuarioSalvo);
	  return usuarioRes;
	 
 }
 
 @GetMapping
 public List<UsuarioRes> listar(){
	 var usuarios=this.usuarioService.listar();
	 return usuarioResCreator.toListModelRes(usuarios);
 }
 
 
 @DeleteMapping("/{id}")
 @ResponseStatus(code = HttpStatus.NO_CONTENT)
 public void buscar(@PathVariable Long id) {
	 this.usuarioService.excluir(id);
	 
 }
 
 @PutMapping("/{id}/senha")
 @ResponseStatus(code = HttpStatus.NO_CONTENT)
 public void alterarSenha(@PathVariable  Long id,@RequestBody @Valid UsuarioSenha dadosUsuario) {
	this.usuarioService.alterarSenha(id,dadosUsuario.getSenhaAtual(),dadosUsuario.getNovaSenha()); 
 }
 
 @PutMapping("/{id}")
 public UsuarioRes alterar(@PathVariable Long id, @RequestBody @Valid UsuarioReq usuarioReq) {
	 var usuarioAtual=this.usuarioService.buscar(id);
	 this.usuarioModelCreator.copyToDomainObject(usuarioReq, usuarioAtual);
	 var usuarioSalvo=this.usuarioService.salvar(usuarioAtual);
	 return this.usuarioResCreator.toModelRes(usuarioSalvo);
 }
 
 
 
 
 
}
