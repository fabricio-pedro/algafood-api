package com.algaworks.algafood.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.algaworks.algafood.api.io.creators.RestauranteModelCreator;
import com.algaworks.algafood.api.io.creators.RestauranteResCreator;
import com.algaworks.algafood.api.io.model.RestauranteModelRes;
import com.algaworks.algafood.api.io.model.RestauranteReq;
import com.algaworks.algafood.domain.exceptions.CozinhaNaoEncotradaException;
import com.algaworks.algafood.domain.exceptions.NegocioException;
import com.algaworks.algafood.domain.services.CadastroRestauranteService;

@RestController
@RequestMapping("restaurantes")
public class RestauranteController {

	@Autowired
	private RestauranteResCreator restauranteResCreator;

	@Autowired
	private RestauranteModelCreator restauranteModelCreator;

	@Autowired
	private CadastroRestauranteService cadastroRestaurante;

	@GetMapping
	public ResponseEntity<List<RestauranteModelRes>> Listar() {
		var restaurantes = this.restauranteResCreator.toListModelRes(this.cadastroRestaurante.listar());
		return ResponseEntity.ok(restaurantes);

	}

	@GetMapping("/{id}")
	public RestauranteModelRes buscar(@PathVariable(name = "id") Long restauranteId) {
		var restaurante = this.cadastroRestaurante.buscar(restauranteId);
		return  this.restauranteResCreator.toModelRes(restaurante);
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public RestauranteModelRes adicionar(@RequestBody @Valid RestauranteReq restauranteReq) {
		try {
			var restaurante = restauranteModelCreator.toModelObject(restauranteReq);
			var restauranteNovo = this.cadastroRestaurante.salvar(restaurante);
			return this.restauranteResCreator.toModelRes(restauranteNovo);
		} catch (CozinhaNaoEncotradaException ex) {
			throw new NegocioException(ex.getMessage());
		}
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long id) {
		this.cadastroRestaurante.excluir(id);
		

	}

	@PutMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public RestauranteModelRes alterar(@PathVariable("id") Long id, @RequestBody RestauranteReq restauranteNovo) {
		try {
			var restauranteAtual = this.cadastroRestaurante.buscar(id);
			this.restauranteModelCreator.copyToDomainObject(restauranteNovo, restauranteAtual);
			var restauranteAtualizado = this.cadastroRestaurante.salvar(restauranteAtual);
			return this.restauranteResCreator.toModelRes(restauranteAtualizado);
		} catch (CozinhaNaoEncotradaException ex) {
			throw new NegocioException(ex.getMessage(), ex);
		}
	}
	
	@PutMapping("/{id}/ativar")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void ativar(@PathVariable Long id) {
		this.cadastroRestaurante.ativar(id);
	}
	
	@DeleteMapping("/{id}/inativar")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void inativar(@PathVariable Long id ) {
		this.cadastroRestaurante.inativar(id);
	}


	 

	
}