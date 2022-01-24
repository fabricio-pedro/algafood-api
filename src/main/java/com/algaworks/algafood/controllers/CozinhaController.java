package com.algaworks.algafood.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.algaworks.algafood.api.model.CozinhaXmlWrapper;
import com.algaworks.algafood.domain.exceptions.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exceptions.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repositories.CozinhaRepository;
import com.algaworks.algafood.domain.services.CadastroCozinhaService;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

@RestController
@RequestMapping("cozinhas")
public class CozinhaController {

	@Autowired
	private CozinhaRepository cozinhaRepository;	
	
	@Autowired
	private CadastroCozinhaService cadastroCozinha;
	
	@GetMapping
	public List<Cozinha> listar(){
		
		return this.cadastroCozinha.listar();
	}
	
	@GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
	public CozinhaXmlWrapper listarXml() {
		return new CozinhaXmlWrapper(this.cozinhaRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public Cozinha getCozinha(@PathVariable Long id) {
		Cozinha cozinha=this.cadastroCozinha.buscar(id);
		return cozinha;
	}
	
	
	@PostMapping
    public ResponseEntity<Cozinha> adicionar(@RequestBody Cozinha cozinha){
		var novaCozinha = this.cadastroCozinha.salvar(cozinha);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				  .path("/{id}").buildAndExpand(novaCozinha.getId())
				  .toUri();
		return ResponseEntity.created(uri).body(novaCozinha);

   }
	@PutMapping("/{id}")
	public Cozinha alterar(@PathVariable Long id,@RequestBody Cozinha cozinha){
		 Cozinha cozinhaAtualizada=this.cadastroCozinha.buscar(id);
		 BeanUtils.copyProperties(cozinha,cozinhaAtualizada,"id");
	 	return this.cadastroCozinha.salvar(cozinhaAtualizada);		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Cozinha> remover(@PathVariable Long id) {
		 this.cadastroCozinha.excluir(id);;
		 return ResponseEntity.noContent().build();
		
	}


}   