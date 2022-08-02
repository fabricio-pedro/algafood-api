package com.algaworks.algafood.api.io.creators;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.api.io.model.ProdutoRes;
import com.algaworks.algafood.domain.model.Produto;

@Component
public class ProdutoResCreator {

 @Autowired	
 private ModelMapper mapper;
 
 public ProdutoRes toModelRes(Produto produto){
	 return this.mapper.map(produto, ProdutoRes.class);
	 
 }
 public List<ProdutoRes> toListModelRes(Collection<Produto> produtos ){
	 
	 var produtosRes=produtos.stream().map(produto->toModelRes(produto)).collect(Collectors.toList());
	 return produtosRes; 
	 }
	
}
