package com.algaworks.algafood.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.api.io.creators.CidadeModelCreator;
import com.algaworks.algafood.api.io.creators.CidadeResCreator;
import com.algaworks.algafood.api.io.model.CidadeReq;
import com.algaworks.algafood.api.io.model.CidadeRes;
import com.algaworks.algafood.domain.exceptions.CidadeNaoEncontradaException;
import com.algaworks.algafood.domain.exceptions.EstadoNaoEncontradoException;
import com.algaworks.algafood.domain.exceptions.NegocioException;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.services.CadastroDeCidadeService;

@RestController
@RequestMapping(value = "/cidades")
public class CidadeController {

	@Autowired
	private CidadeModelCreator cidadeModelCreator;
	
	@Autowired
	private CidadeResCreator cidadeResCreator;
	
	@Autowired
	private CadastroDeCidadeService cidadeService;
	
	@GetMapping
	public List<Cidade> listar(){
		return this.cidadeService.listar();
	}
	
	
	@Transactional
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public CidadeRes salvar(@RequestBody @Valid CidadeReq cidade) {
		try {
		  var novaCidade=this.cidadeModelCreator.toModelObject(cidade);
		  var cidadeSalva= this.cidadeService.salvar(novaCidade);
		  return this.cidadeResCreator.toModelRes(cidadeSalva);
		}catch(EstadoNaoEncontradoException ex) {
			throw new NegocioException(ex.getMessage());
		}
		
	}
	
	@GetMapping("/{id}")
	public CidadeRes buscar (@PathVariable("id") Long id) {
		return  this.cidadeResCreator.toModelRes(this.cidadeService.buscar(id));
		
	}
	
	@Transactional
	@PutMapping
	public CidadeRes alterar(@PathVariable Long id, CidadeReq cidadeReq) {
		 var cidadeAtual=this.cidadeService.buscar(id);
		try {
	          this.cidadeModelCreator.copyToDomainObject(cidadeReq,cidadeAtual);	 
		      var cidadeAtualizada=this.cidadeService.salvar(cidadeAtual);
		      return this.cidadeResCreator.toModelRes(cidadeAtualizada);
		}catch(EstadoNaoEncontradoException ex){
			throw new NegocioException(ex.getMessage(),ex);
			
		}
	}
	
	
	
	
}
