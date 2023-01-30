package com.algaworks.algafood.api.controllers;



import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.api.io.creators.FotoProdudtoResCreator;
import com.algaworks.algafood.api.io.model.FotoProdutoReq;
import com.algaworks.algafood.api.io.model.FotoProdutoRes;
import com.algaworks.algafood.domain.exceptions.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.FotoProduto;
import com.algaworks.algafood.domain.services.CadastroProdutoService;
import com.algaworks.algafood.domain.services.CatalogoFotoProdutoService;
import com.algaworks.algafood.domain.services.FotoStorageService;

@RestController
@RequestMapping(path = "/restaurantes/{restauranteId}/produtos/{produtoId}/foto")
public class RestauranteProdutoFotoController {
    
	@Autowired
	private FotoProdudtoResCreator fotoProdutoResCreator;
	
	@Autowired
	private CadastroProdutoService cadProdutoService;
	 
	@Autowired
	private CatalogoFotoProdutoService catalogoFotoProdutoService;
	
	@Autowired
	private FotoStorageService storageService;
	
	
	@PutMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public FotoProdutoRes atualizarFoto(@PathVariable Long restauranteId,@PathVariable Long produtoId, 
			              @Valid  FotoProdutoReq fotoReq ) throws IOException {
	     var arquivo=fotoReq.getArquivo();
		 var produto =cadProdutoService.buscar(restauranteId, produtoId);
		
		 var foto=new FotoProduto();
		 foto.setProduto(produto);
		 foto.setDescricao(fotoReq.getDescricao());
		 foto.setContentType(arquivo.getContentType());
		 foto.setTamanho(arquivo.getSize());
		 foto.setNomeArquivo(arquivo.getOriginalFilename());
		 var fotoSalva= this.catalogoFotoProdutoService.salvar(foto,arquivo.getInputStream());;
		 return fotoProdutoResCreator.toModelRes(fotoSalva);
		
	}
	
	@GetMapping (produces = MediaType.APPLICATION_JSON_VALUE)
	public FotoProdutoRes buscarFoto(@PathVariable Long restauranteId,@PathVariable Long produtoId) {
	 var fotoProduto=catalogoFotoProdutoService.buscar(restauranteId,produtoId);
	 var fotoRes=this.fotoProdutoResCreator.toModelRes(fotoProduto);
	 return fotoRes;
	}
	@GetMapping
	public ResponseEntity<InputStreamResource> servirFoto(@PathVariable Long restauranteId,@PathVariable Long produtoId, @RequestHeader(name = "Accept") String acceptHeaders) throws HttpMediaTypeNotAcceptableException {
	  try {
	   var fotoProduto=catalogoFotoProdutoService.buscar(restauranteId,produtoId);
	   var inputStream=  storageService.recuperar(fotoProduto.getNomeArquivo());
	   MediaType mediaTypeFoto=MediaType.parseMediaType(fotoProduto.getContentType());
	   List<MediaType> mediaTypeAceitas=MediaType.parseMediaTypes(acceptHeaders);
	   verificaCompatibilidadeMediaType(mediaTypeFoto, mediaTypeAceitas);
	   var resource = new InputStreamResource(inputStream);
	  
	   return ResponseEntity.ok()
			              .contentType(mediaTypeFoto)
			              .body(resource);
	  }catch (EntidadeNaoEncontradaException ex) {
		  return ResponseEntity.notFound()
				               .build();
	  }
	}
	@DeleteMapping
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void excluir(@PathVariable Long restauranteId,@PathVariable Long produtoId) {
	  this.catalogoFotoProdutoService.excluir(restauranteId, produtoId);	
	} 
	
	
	private void verificaCompatibilidadeMediaType(MediaType mediaTypeFoto,List<MediaType> mediaTypesAceitas) throws HttpMediaTypeNotAcceptableException {
		 
	 boolean consome=mediaTypesAceitas.stream().anyMatch(m->m.isCompatibleWith(mediaTypeFoto));
		
		if(!consome) {
			throw new HttpMediaTypeNotAcceptableException(mediaTypesAceitas);
		}
	}
}
