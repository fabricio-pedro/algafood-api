package com.algaworks.algafood.controllers;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.exceptions.CozinhaNaoEncotradaException;
import com.algaworks.algafood.domain.exceptions.NegocioException;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.services.CadastroRestauranteService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
@RestController
@RequestMapping("restaurantes")
public class RestauranteController {

 	
	
 @Autowired	
 private CadastroRestauranteService cadastroRestaurante;	

 @GetMapping
 public ResponseEntity<List<Restaurante>> Listar(){
	     List<Restaurante> restaurantes=this.cadastroRestaurante.listar();
	 return ResponseEntity.ok(restaurantes);
	 
 }	
 @GetMapping("/{id}")
 public Restaurante buscar(@PathVariable(name = "id")  Long restauranteId) {
      var restaurante = this.cadastroRestaurante.buscar(restauranteId);
      return restaurante;
 }

 @PostMapping
 @ResponseStatus(code = HttpStatus.CREATED)
 public Restaurante adicionar(@RequestBody @Valid Restaurante restaurante){
	 try {
		var restauranteNovo=this.cadastroRestaurante.salvar(restaurante);
		return restauranteNovo;
	 }catch(CozinhaNaoEncotradaException ex) {
		throw new NegocioException(ex.getMessage()); 
	 }
 }
 
    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long id) {
		 this.cadastroRestaurante.excluir(id);;
		
	}
 
     @PutMapping("/{id}")
     @ResponseStatus(code = HttpStatus.OK)
     public Restaurante alterar(@PathVariable("id") Long id,@RequestBody Restaurante restauranteNovo){
	    var restauranteAtual = this.cadastroRestaurante.buscar(id);
	   	BeanUtils.copyProperties(restauranteNovo, restauranteAtual,"id","produtos","formasPagamentos","dataCadastro");
	   	 try {
	     var restauranteAtualizado=	this.cadastroRestaurante.salvar(restauranteAtual);
		   return restauranteAtualizado;
	   	 }catch(CozinhaNaoEncotradaException ex) {
	   	  	 throw new NegocioException(ex.getMessage(),ex);
	   	 }
	  }
	  
 
 
 @PatchMapping("/{id}")
 public Restaurante alterarParcial(@PathVariable Long id,@RequestBody Map<String, Object> campos, HttpServletRequest request){
	 var restauranteAtual=this.cadastroRestaurante.buscar(id);
	 merge(campos, restauranteAtual,request);
	 return alterar(id, restauranteAtual);
	 
 }

	private void merge(Map<String, Object> dadosOrigem, Restaurante restauranteDestino,  HttpServletRequest request ) {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
		objectMapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES,true);
		ServletServerHttpRequest serverHttpRequest = new ServletServerHttpRequest(request);
         try{   
		    Restaurante restauranteOrigem = objectMapper.convertValue(dadosOrigem, Restaurante.class);
		    dadosOrigem.forEach((nomePropriedade, valorPropriedade) -> {
			Field field = ReflectionUtils.findField(Restaurante.class, nomePropriedade);
			field.setAccessible(true);

			Object novoValor = ReflectionUtils.getField(field, restauranteOrigem);

			System.out.println(nomePropriedade + " = " + valorPropriedade + " = " + novoValor);

			ReflectionUtils.setField(field, restauranteDestino, novoValor);
		});
        }catch(IllegalArgumentException ex) {
        	Throwable rootCause=ExceptionUtils.getRootCause(ex);
        	throw new HttpMessageNotReadableException(ex.getMessage(), rootCause, serverHttpRequest);
        }  
         
	}
	
	
 
}