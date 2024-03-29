package com.algaworks.algafood.api.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.algaworks.algafood.api.io.creators.CozinhaModelCreator;
import com.algaworks.algafood.api.io.creators.CozinhaResCreator;
import com.algaworks.algafood.api.io.model.CozinhaReq;
import com.algaworks.algafood.api.io.model.CozinhaRes;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repositories.CozinhaRepository;
import com.algaworks.algafood.domain.services.CadastroCozinhaService;

@RestController
@RequestMapping("cozinhas")
public class CozinhaController {
	
	@Autowired
	private CozinhaResCreator cozinhaResCreator;
	
	@Autowired
	private CozinhaModelCreator cozinhaCreator;
	
	
	@Autowired
	private CadastroCozinhaService cadastroCozinha;
	
	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	@GetMapping
	public Page<CozinhaRes> listar(@PageableDefault(size = 2) Pageable pageable){
		Page<Cozinha> cozinhasPage=  this.cozinhaRepository.findAll(pageable);
		var cozinhasModel=this.cozinhaResCreator.toListModelRes(cozinhasPage.getContent());
		Page<CozinhaRes> cozinhaResPage=new PageImpl<>(cozinhasModel,pageable,cozinhasPage.getTotalElements());
		return  cozinhaResPage;
	}
	

	
	@GetMapping("/{id}")
	public CozinhaRes buscar(@PathVariable Long id) {
		Cozinha cozinha=this.cadastroCozinha.buscar(id);
		return this.cozinhaResCreator.toModelRes(cozinha);
	}
	
	

	@PostMapping
    public ResponseEntity<CozinhaRes> adicionar(@RequestBody @Valid CozinhaReq cozinhaReq){
		var cozinha=this.cozinhaCreator.toModelObject(cozinhaReq);
		var novaCozinha = this.cadastroCozinha.salvar(cozinha);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				  .path("/{id}").buildAndExpand(novaCozinha.getId())
				  .toUri();
		return ResponseEntity.created(uri).body(cozinhaResCreator.toModelRes(novaCozinha));

   }
	
	@PutMapping("/{id}")
	public CozinhaRes alterar(@PathVariable Long id,@RequestBody CozinhaReq cozinhaReq){
		 Cozinha cozinhaAtualizada=this.cadastroCozinha.buscar(id);
		 cozinhaCreator.copyToDomainObject(cozinhaReq, cozinhaAtualizada);
		 
	 	return  cozinhaResCreator.toModelRes(this.cadastroCozinha.salvar(cozinhaAtualizada));		
	}
	@Transactional
	@DeleteMapping("/{id}")
	public ResponseEntity<Cozinha> remover(@PathVariable Long id) {
		 this.cadastroCozinha.excluir(id);;
		 return ResponseEntity.noContent().build();
		
	}


}   