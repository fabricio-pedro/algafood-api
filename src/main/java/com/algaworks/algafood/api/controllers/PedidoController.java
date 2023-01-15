package com.algaworks.algafood.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.services.GerenciadorDePedidosService;

@RestController
@RequestMapping("/pedidos/{codigo}")
public class PedidoController {

  @Autowired	
  private GerenciadorDePedidosService pedidosService;
	
  @PutMapping("/confirmacao")
  @ResponseStatus(value = HttpStatus.NO_CONTENT)
  public void confirmarPedido(@PathVariable("codigo") String codigo) {
   	   this.pedidosService.confirmar(codigo);
	  
  }
  @PutMapping("/cancelamento")
  @ResponseStatus(value = HttpStatus.NO_CONTENT)
  public void cancelarPedido(@PathVariable("codigo") String codigo) {
   	   this.pedidosService.cancelar(codigo);
	  
  }
  @PutMapping("/entrega")
  @ResponseStatus(value = HttpStatus.NO_CONTENT)
  public void entregarPedido(@PathVariable("codigo") String codigo) {
	
   	   this.pedidosService.entregar(codigo);
	  
  }
	
}
