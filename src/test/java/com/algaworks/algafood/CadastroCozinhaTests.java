package com.algaworks.algafood;

import static org.assertj.core.api.Assertions.assertThat;

import javax.validation.ConstraintViolationException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.algaworks.algafood.domain.exceptions.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exceptions.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.services.CadastroCozinhaService;

@SpringBootTest
public class CadastroCozinhaTests {

  @Autowired	
  private CadastroCozinhaService cozinhaService;

  @Test
  public void deveRetornarCozinhaComIdQuandoFornecidoDadosCorretos() {
	Cozinha cozinhaSalva=new Cozinha();
	cozinhaSalva.setNome("Irlandesa");
	cozinhaSalva=cozinhaService.salvar(cozinhaSalva);
	assertThat(cozinhaSalva).isNotNull();
	assertThat(cozinhaSalva.getId()).isNotNull();
	  
  }	
  
 @Test  
 public void deveFalharQuandoNaoFornecidoDadosCorretos() {
	 Cozinha cozinhaSalva=new Cozinha();
	 Assertions.assertThrows(ConstraintViolationException.class, ()->cozinhaService.salvar(cozinhaSalva));
 } 
 
 @Test
 public void deveFalharAoExcluirCozinhoEmUso() {
	Assertions.assertThrows(EntidadeEmUsoException.class, ()->cozinhaService.excluir(1l)); 
	 
 }
 @Test
 public void deveFalharAoExcluirCozinhaInexistente() {
	Assertions.assertThrows(EntidadeNaoEncontradaException.class,()->cozinhaService.excluir(50l)); 
 }
	
}
