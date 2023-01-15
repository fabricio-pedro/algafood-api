package com.algaworks.algafood.api.controllers;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.api.io.creators.PedidoModelCreator;
import com.algaworks.algafood.api.io.creators.PedidoResCreator;
import com.algaworks.algafood.api.io.creators.PedidoResumoCreator;
import com.algaworks.algafood.api.io.model.PedidoReq;
import com.algaworks.algafood.api.io.model.PedidoRes;
import com.algaworks.algafood.api.io.model.PedidoResumoModel;
import com.algaworks.algafood.core.data.PageableTranslator;
import com.algaworks.algafood.domain.model.Pedido;
import com.algaworks.algafood.domain.repositories.PedidoRepository;
import com.algaworks.algafood.domain.repositories.filters.PedidoFilter;
import com.algaworks.algafood.domain.services.EmissorDePedidoService;
import com.algaworks.algafood.domain.services.GerenciadorDePedidosService;
import com.algaworks.algafood.infrastructure.repository.spec.PedidoSpecs;

@RestController
@RequestMapping("/pedidos")
public class EmissorDePedidoController {

	@Autowired
	private EmissorDePedidoService pedidoService;
	@Autowired
    private PedidoResCreator pedidoResCreator;
    
	@Autowired
	private GerenciadorDePedidosService gerenciadorDePedidosService;
	
	@Autowired
	private PedidoModelCreator pedidoModelCreator;
    
	@Autowired
	private PedidoResumoCreator pedidoResumoCreator;
	
   @Autowired
   private PedidoRepository pedidoRepository;
    
    @PostMapping
    public PedidoRes emitir(@RequestBody @Valid PedidoReq pedidoReq) {
    	var pedido=this.pedidoModelCreator.toModelObject(pedidoReq);
        var pedidoSalvo=this.pedidoService.emitir(pedido);
        System.out.println("Salvando um pedido..."+pedidoSalvo.getDataEntrega());
        return this.pedidoResCreator.toModelRes(pedidoSalvo);
    }
    
    
    @GetMapping("/{codigo}")
    public PedidoRes buscar(@PathVariable("codigo") String codigo) {
    	var pedidoEncontrado=this.pedidoService.buscar(codigo);
    	return this.pedidoResCreator.toModelRes(pedidoEncontrado);
    }
    
    @GetMapping
	public Page<PedidoResumoModel> pesquisar(PedidoFilter filtro,@PageableDefault(size=2) Pageable pageable) {
  
        var pageTranslated=traduzirPageable(pageable);    
    	Page<Pedido> Pedidospage=this.pedidoRepository.findAll(PedidoSpecs.usandoFiltro(filtro), pageTranslated);
		var pedidoModelRes=pedidoResumoCreator.toListModelRes(Pedidospage.getContent());
        Page<PedidoResumoModel> pedidoPageRes=new PageImpl<>(pedidoModelRes,pageable,Pedidospage.getTotalElements()); 
        return pedidoPageRes;
	}
    private Pageable traduzirPageable(Pageable apiPageable) {
		var mapeamento = Map.of(
				"codigo", "codigo",
				"subtotal", "subtotal",
				"taxaFrete", "taxaFrete",
				"valorTotal", "valorTotal",
				"dataCriacao", "dataCriacao",
				"restaurante.nome", "restaurante.nome",
				"restaurante.id", "restaurante.id",
				"cliente.id", "cliente.id",
				"cliente.nome", "cliente.nome"
			);
		
		return PageableTranslator.translate(apiPageable, mapeamento);
	}
   
	
}
