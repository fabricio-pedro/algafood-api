package com.algaworks.algafood.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.exceptions.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exceptions.EntidadeNaoEncontrada;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.services.CadastroEstadoService;

@RestController
@RequestMapping(path = "estados",produces = MediaType.APPLICATION_JSON_VALUE)
public class EstadoController {
	
	@Autowired
	private CadastroEstadoService cadastroEstado;
    @GetMapping
	public ResponseEntity<List<Estado>> listar(){
    	 return ResponseEntity.ok(this.cadastroEstado.listar());
		
	}
	
	@ResponseStatus(value = HttpStatus.OK)
	@GetMapping("/{id}")
	public ResponseEntity<?> buscar(@PathVariable Long id) {
       try {
    	 var estadoEncontrado = this.cadastroEstado.buscarPor(id);
    	 return ResponseEntity.ok(estadoEncontrado);
       }catch(EntidadeNaoEncontrada ex) {
    	   return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
       }
	
	}
	@DeleteMapping("/{estado_id}")
	public ResponseEntity<?> remover(@PathVariable(name = "estado_id") Long id){
		try {
			this.cadastroEstado.excluir(id);
			return ResponseEntity.noContent().build();
		}catch(EntidadeNaoEncontrada ex) {
			return ResponseEntity.notFound().build();
		}catch(EntidadeEmUsoException ex) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
			
		}
	}

}
