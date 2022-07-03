package com.algaworks.algafood.api.io.creators;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.api.io.model.CidadeReq;
import com.algaworks.algafood.api.io.model.CozinhaReq;
import com.algaworks.algafood.api.io.model.FormaPagamentoReq;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.FormaPagamento;

@Component
public class FormaPagamentoModelCreator {
	
    @Autowired
	private ModelMapper mapper;
	
    public FormaPagamento toModelObject(FormaPagamentoReq formaPgReq) {
    	return this.mapper.map(formaPgReq, FormaPagamento.class);
    }
    public void copyToDomainObject(FormaPagamentoReq formaPgReq,FormaPagamento formaPg) {
    	
       	 this.mapper.map(formaPgReq, formaPg);
    }
    
}
