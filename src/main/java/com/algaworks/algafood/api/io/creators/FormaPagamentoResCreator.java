package com.algaworks.algafood.api.io.creators;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.api.io.model.FormaPagamentoRes;
import com.algaworks.algafood.domain.model.FormaPagamento;

@Component
public class FormaPagamentoResCreator {

 @Autowired	
 private ModelMapper mapper;
 
 public FormaPagamentoRes toModelRes(FormaPagamento formaPg){
	 return this.mapper.map(formaPg, FormaPagamentoRes.class);
	 
 }
 public List<FormaPagamentoRes> toListModelRes(Collection<FormaPagamento> formasDePagamento ){
	 
	 var formasPgRes=formasDePagamento.stream().map(forma->toModelRes(forma)).collect(Collectors.toList());
	 return formasPgRes; 
	 }
	
}
