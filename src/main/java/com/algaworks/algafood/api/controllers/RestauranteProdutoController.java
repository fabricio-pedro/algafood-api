package com.algaworks.algafood.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.api.io.creators.ProdutoModelCreator;
import com.algaworks.algafood.api.io.creators.ProdutoResCreator;
import com.algaworks.algafood.api.io.model.ProdutoReq;
import com.algaworks.algafood.api.io.model.ProdutoRes;
import com.algaworks.algafood.domain.services.CadastroProdutoService;
import com.algaworks.algafood.domain.services.CadastroRestauranteService;

@RestController
@RequestMapping("/restaurantes/{restauranteId}/produtos")
public class RestauranteProdutoController {
	
	@Autowired
  	private CadastroProdutoService produtoService;
	
	@Autowired
	private CadastroRestauranteService restauranteService;
	
	@Autowired
	private ProdutoModelCreator produtoModelCreator;
	
	@Autowired
	private ProdutoResCreator produtoResCreator;
    @PostMapping
	public ProdutoRes incluirProduto(@PathVariable("restauranteId") Long id, @RequestBody @Valid ProdutoReq produtoReq) {
		
    	var restaurante=this.restauranteService.buscar(id);
		var produto=this.produtoModelCreator.toModelObject(produtoReq);
		produto.setRestaurante(restaurante);
	    var produtoSalvo=this.produtoService.salvar(produto);
		return this.produtoResCreator.toModelRes(produtoSalvo);
	}
 	
    @GetMapping
    public List<ProdutoRes> listar(@PathVariable Long restauranteId){
    	var produtosDoRestaurante=this.restauranteService.buscar(restauranteId).getProdutos();
    	var produtosRes=this.produtoResCreator.toListModelRes(produtosDoRestaurante);
        return produtosRes;
    }
   
    @GetMapping("/{produtoId}")
    public ProdutoRes buscarPor(@PathVariable Long restauranteId,@PathVariable Long produtoId) {
        this.restauranteService.buscar(restauranteId);
    	var produtoEncontrado=this.produtoService.buscar(restauranteId, produtoId);
    	return this.produtoResCreator.toModelRes(produtoEncontrado); 
       
       
    }
    
    @PutMapping("/{produtoId}")
    public ProdutoRes alterar(@PathVariable Long restauranteId, @PathVariable Long produtoId,@RequestBody @Valid ProdutoReq produtoReq) {
           this.restauranteService.buscar(restauranteId);
       var produtoEncontrado=this.produtoService.buscar(restauranteId, produtoId);
    	   this.produtoModelCreator.copyToDomainObject(produtoReq, produtoEncontrado);
       var produtoAtualizado=this.produtoService.salvar(produtoEncontrado);
    	   return this.produtoResCreator.toModelRes(produtoAtualizado);
    }
    

}
