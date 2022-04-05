package com.algaworks.algafood.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.api.io.creators.EstadoModelCreator;
import com.algaworks.algafood.api.io.creators.EstadoResCreator;
import com.algaworks.algafood.api.io.model.EstadoReq;
import com.algaworks.algafood.api.io.model.EstadoRes;
import com.algaworks.algafood.domain.exceptions.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exceptions.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.services.CadastroEstadoService;

@RestController
@RequestMapping(path = "estados",produces = MediaType.APPLICATION_JSON_VALUE)
public class EstadoController {
	
	@Autowired
	private EstadoResCreator estadoResCreator;
	
	@Autowired
	private EstadoModelCreator estadoModelCreator;
	
	@Autowired
	private CadastroEstadoService cadastroEstado;
    @GetMapping
	public List<EstadoRes> listar(){
    	 var estados=this.estadoResCreator.toListModelRes(this.cadastroEstado.listar()); 
    	return estados;
		
	}
	
	
	@GetMapping("/{id}")
	public EstadoRes buscar(@PathVariable Long id) {
    	 var estadoEncontrado = this.cadastroEstado.buscarPor(id);
    	 return this.estadoResCreator.toModelRes(estadoEncontrado);
      
	
	}
	@DeleteMapping("/{estado_id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void remover(@PathVariable(name = "estado_id") Long id){
			this.cadastroEstado.excluir(id);
			
		
	}
	@PostMapping
	public EstadoRes salvar(@RequestBody @Valid EstadoReq estadoReq) {
		var estado=this.estadoModelCreator.toModelObject(estadoReq);
		var estadoSalvo=this.cadastroEstado.salvar(estado);
        return this.estadoResCreator.toModelRes(estadoSalvo);	
	}
	
	@PutMapping("/{id}")
	public EstadoRes alterar(@PathVariable Long id,@RequestBody @Valid EstadoReq estadoReq) {
		 var estadoAtual=this.cadastroEstado.buscarPor(id);
		 this.estadoModelCreator.copyToDomainObject(estadoReq, estadoAtual);
		 var estadoAtualizado=this.cadastroEstado.salvar(estadoAtual);
		 return this.estadoResCreator.toModelRes(estadoAtualizado);
	}
	

}
