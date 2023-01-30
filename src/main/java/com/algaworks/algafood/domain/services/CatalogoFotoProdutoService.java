package com.algaworks.algafood.domain.services;

import java.io.InputStream;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.exceptions.FotoNaoEncontradaException;
import com.algaworks.algafood.domain.model.FotoProduto;
import com.algaworks.algafood.domain.repositories.ProdutoRepository;
import com.algaworks.algafood.domain.services.FotoStorageService.NovaFoto;


@Service
public class CatalogoFotoProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private FotoStorageService fotoStorageService;
	
	@Transactional
	public FotoProduto salvar(FotoProduto fotoProduto,InputStream dadosFoto) {
		 var restauranteId=fotoProduto.getRestauranteId();
		 var produtoId=fotoProduto.getProduto().getId();
		 Optional<FotoProduto> fotoExiste=this.produtoRepository.findFotoById(restauranteId, produtoId);
		 String nomeArquivoExistente=null;	
			  if(fotoExiste.isPresent()) {
				  nomeArquivoExistente=fotoExiste.get().getNomeArquivo();
				  this.produtoRepository.delete(fotoExiste.get());
			  
			  }
			 
			 var nomeNovoArquivo=this.fotoStorageService.gerarNomeArquivo(fotoProduto.getNomeArquivo()); 
		     fotoProduto.setNomeArquivo(nomeNovoArquivo);
			 var fotoSalva=this.produtoRepository.save(fotoProduto);
		     this.produtoRepository.flush();
			 NovaFoto novaFoto=NovaFoto.builder().
					           nome(nomeNovoArquivo).
					           inputStream(dadosFoto).
					           build();
			 
	    this.fotoStorageService.substituir(nomeArquivoExistente, novaFoto);;		 
		return fotoSalva;
	}
	
	public FotoProduto buscar(Long restauranteId, Long produtoId) {
	
		return this.produtoRepository.findFotoById(restauranteId, produtoId)
				                     .orElseThrow(()-> new FotoNaoEncontradaException(restauranteId,produtoId));
	}
	 
 @Transactional	
 public void excluir(Long restauranteId, Long produtoId) {
	var fotoProduto=buscar(restauranteId, produtoId);
	this.produtoRepository.delete(fotoProduto);
	this.produtoRepository.flush();
	this.fotoStorageService.remover(fotoProduto.getNomeArquivo());
 
 }
	   



  }
