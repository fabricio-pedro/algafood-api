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

import com.algaworks.algafood.api.io.creators.FormaPagamentoModelCreator;
import com.algaworks.algafood.api.io.creators.FormaPagamentoResCreator;
import com.algaworks.algafood.api.io.model.FormaPagamentoReq;
import com.algaworks.algafood.api.io.model.FormaPagamentoRes;
import com.algaworks.algafood.domain.services.CadastroFormaPagamentoService;

@RestController
@RequestMapping("formas-de-pagamento")
public class FormaPagamentoController {
    
	@Autowired
	private CadastroFormaPagamentoService formaPgService;
    @Autowired
	private FormaPagamentoResCreator formaPgResCreator;
    
    @Autowired
    private FormaPagamentoModelCreator formaPgModelCreator;
    
    @PostMapping
    public FormaPagamentoRes adicionar(@Valid @RequestBody FormaPagamentoReq formaPgReq) {
    	var formaPg=this.formaPgModelCreator.toModelObject(formaPgReq);
        var formaPgSaved=this.formaPgService.salvar(formaPg);
        return this.formaPgResCreator.toModelRes(formaPgSaved);
    	
    }

    @GetMapping("/{id}")
    public FormaPagamentoRes buscar(@PathVariable Long id) {
    	var formaPg=this.formaPgService.buscarPor(id);
    	return this.formaPgResCreator.toModelRes(formaPg);
    	
    }
    
	@PutMapping("/{id}")
	public FormaPagamentoRes alterar(@PathVariable Long id, @RequestBody FormaPagamentoReq formaPgReq) {
		 var formaPgAtual=this.formaPgService.buscarPor(id);
	     this.formaPgModelCreator.copyToDomainObject(formaPgReq,formaPgAtual);	 
		 var formaPgAtualizado=this.formaPgService.salvar(formaPgAtual);
		 return this.formaPgResCreator.toModelRes(formaPgAtualizado);
		
	}
	
	@GetMapping
	public List<FormaPagamentoRes> listar(){
	    return this.formaPgResCreator.toListModelRes(this.formaPgService.listar());	
	} 
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id) {
    	this.formaPgService.excluir(id);
    	
    }
    
	
}
