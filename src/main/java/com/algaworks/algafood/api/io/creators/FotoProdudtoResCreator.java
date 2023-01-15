package com.algaworks.algafood.api.io.creators;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.api.io.model.CidadeRes;
import com.algaworks.algafood.api.io.model.FotoProdutoRes;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.model.FotoProduto;

@Component
public class FotoProdudtoResCreator {

 @Autowired	
 private ModelMapper mapper;
 
 public FotoProdutoRes toModelRes(FotoProduto fotoProduto){
	 return this.mapper.map(fotoProduto,FotoProdutoRes.class);
	 
 }
 public List<FotoProdutoRes> toListModelRes(List<FotoProduto> fotos){
	 
	 var fotosProdutosRes=fotos.stream().map(c->toModelRes(c)).collect(Collectors.toList());
	 return fotosProdutosRes; 
	 }
	
}
