package com.algaworks.algafood.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.api.io.creators.GrupoResCreator;
import com.algaworks.algafood.api.io.model.GrupoRes;
import com.algaworks.algafood.domain.services.CadastroUsuarioService;

@RestController
@RequestMapping("/usuarios/{usuarioId}/grupos")
public class UsuarioGrupoController {
    
	@Autowired
	private CadastroUsuarioService usuarioService;
	
	@Autowired
	private GrupoResCreator grupoResCreator;
	
	@GetMapping
	public List<GrupoRes> listar(@PathVariable Long usuarioId){
		var usuarioEncontado=this.usuarioService.buscar(usuarioId);
		var gruposRes=this.grupoResCreator.toListModelRes(usuarioEncontado.getGrupos());
	    return gruposRes;
	}
	@PutMapping("/{grupoId}")
	public void associar(@PathVariable Long usuarioId, @PathVariable Long grupoId) {
		this.usuarioService.associarGrupo(usuarioId, grupoId);
	}
	@DeleteMapping("/{grupoId}")
	public void desassociar(@PathVariable Long usuarioId, @PathVariable Long grupoId) {
		this.usuarioService.desassociarGrupo(usuarioId, grupoId);
	}
	
}
