package com.algaworks.algafood.api.controllers;



import java.nio.file.Path;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.api.io.creators.FotoProdudtoResCreator;
import com.algaworks.algafood.api.io.model.FotoProdutoReq;
import com.algaworks.algafood.api.io.model.FotoProdutoRes;
import com.algaworks.algafood.domain.model.FotoProduto;
import com.algaworks.algafood.domain.services.CadastroProdutoService;
import com.algaworks.algafood.domain.services.CatalogoFotoProdutoService;

@RestController
@RequestMapping(path = "/restaurantes/{restauranteId}/produtos/{produtoId}/foto")
public class RestauranteProdutoFotoController {
    
	@Autowired
	private FotoProdudtoResCreator fotoProdutoResCreator;
	
	@Autowired
	private CadastroProdutoService cadProdutoService;
	 
	@Autowired
	private CatalogoFotoProdutoService catalogoFotoProdutoService;
	
	@PutMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public FotoProdutoRes atualizarFoto(@PathVariable Long restauranteId,@PathVariable Long produtoId, 
			              @Valid  FotoProdutoReq fotoReq ) {
	     var arquivo=fotoReq.getArquivo();
		 var produto =cadProdutoService.buscar(restauranteId, produtoId);
		
		 var foto=new FotoProduto();
		 foto.setProduto(produto);
		 foto.setDescricao(fotoReq.getDescricao());
		 foto.setContentType(arquivo.getContentType());
		 foto.setTamanho(arquivo.getSize());
		 foto.setNomeArquivo(arquivo.getOriginalFilename());
		 var fotoSalva= this.catalogoFotoProdutoService.salvar(foto);
		 return fotoProdutoResCreator.toModelRes(fotoSalva);
		
	}
	
}
