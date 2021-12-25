package com.algaworks.algafood.controllers;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.exceptions.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exceptions.EntidadeNaoEncontrada;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.services.CadastroRestauranteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.logging.Logger;
@RestController
@RequestMapping("restaurantes")
public class RestauranteController {

 	
	
 @Autowired	
 private CadastroRestauranteService cadastroRestaurante;	

 @GetMapping
 public ResponseEntity<List<Restaurante>> Listar(){
	     List<Restaurante> restaurantes=this.cadastroRestaurante.listar();
	     System.err.println("Cozinha do restaurante "+restaurantes.get(0).getCozinha().getNome());
	     System.err.println("Cozinha do restaurante "+restaurantes.get(1).getCozinha().getNome());
	 return ResponseEntity.ok(restaurantes);
	 
 }	
 @GetMapping("/{id}")
 public ResponseEntity<Restaurante> buscar(@PathVariable(name = "id")  Long restauranteId) {
      var restaurante = this.cadastroRestaurante.buscar(restauranteId);
      if(restaurante!=null) {
    	  return ResponseEntity.ok(restaurante);
      }
      return ResponseEntity.notFound().build();
 }

 @PostMapping
 public ResponseEntity<?> add(@RequestBody Restaurante restaurante){
	 try {
		var restauranteNovo=this.cadastroRestaurante.salvar(restaurante);
		return ResponseEntity.ok(restauranteNovo);
	 }catch(EntidadeNaoEncontrada ex) {
		return ResponseEntity.badRequest().body(ex.getMessage()); 
	 }
 }
 
 @DeleteMapping("/{id}")
	public ResponseEntity<Restaurante> remover(@PathVariable Long id) {
		try {
		 this.cadastroRestaurante.excluir(id);;
		 return ResponseEntity.noContent().build();
		}catch(EntidadeNaoEncontrada ex) {
		  return ResponseEntity.notFound().build();
		}
		catch(EntidadeEmUsoException ex) {
		 return ResponseEntity.status(HttpStatus.CONFLICT).build();
	     
		}
	}
 
 @PutMapping("/{id}")
     public ResponseEntity<?> alterar(@PathVariable("id") Long id,@RequestBody Restaurante restauranteNovo){
	  var restauranteAtual = this.cadastroRestaurante.buscar(id);
	  
	  if (restauranteAtual!=null) {
	   	BeanUtils.copyProperties(restauranteNovo, restauranteAtual,"id","produtos","formasPagamentos");
	   	 try {
	     var restauranteAtualizado=	this.cadastroRestaurante.salvar(restauranteAtual);
		 return ResponseEntity.ok(restauranteAtualizado);
	   	 }catch(EntidadeNaoEncontrada ex) {
	   	  	 return ResponseEntity.badRequest().body(ex.getMessage());
	   	 }
	  }
	  return ResponseEntity.status(HttpStatus.NOT_FOUND)
			                .body(String.format("Não há um restaurante com o código %s para atualizar", id));
 }
 
 @PatchMapping("/{id}")
 public ResponseEntity<?> alterarParcial(@PathVariable Long id,@RequestBody Map<String, Object> campos){
	var restauranteAtual=this.cadastroRestaurante.buscar(id);
	 if(restauranteAtual==null) {
		 return ResponseEntity.notFound().build();
	 }
	System.out.println(campos);
	 merge(campos, restauranteAtual);
	 
	 System.out.println("DAdos do restaurante atualizado:"+restauranteAtual);
	 
	 return alterar(id, restauranteAtual);
	 
 }

	private void merge(Map<String, Object> dadosOrigem, Restaurante restauranteDestino) {
		ObjectMapper objectMapper = new ObjectMapper();
		Restaurante restauranteOrigem = objectMapper.convertValue(dadosOrigem, Restaurante.class);

		dadosOrigem.forEach((nomePropriedade, valorPropriedade) -> {
			Field field = ReflectionUtils.findField(Restaurante.class, nomePropriedade);
			field.setAccessible(true);

			Object novoValor = ReflectionUtils.getField(field, restauranteOrigem);

			System.out.println(nomePropriedade + " = " + valorPropriedade + " = " + novoValor);

			ReflectionUtils.setField(field, restauranteDestino, novoValor);
		});
	}


}