package com.algaworks.algafood.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algafood.domain.exceptions.NegocioException;
import com.algaworks.algafood.domain.exceptions.PedidoNaoEncontradoException;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.model.FormaPagamento;
import com.algaworks.algafood.domain.model.Pedido;
import com.algaworks.algafood.domain.model.Produto;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.model.Usuario;
import com.algaworks.algafood.domain.repositories.PedidoRepository;

@Service
public class EmissorDePedidoService {
    
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private CadastroDeCidadeService cidadeService;
	
	@Autowired
	private CadastroUsuarioService usuarioService;
    @Autowired
	private CadastroRestauranteService restauranteService;
	
    @Autowired
    private CadastroFormaPagamentoService formaPagamentoService;
    
    @Autowired
    private CadastroProdutoService produtoService;
    
	public List<Pedido> listar(){
		return this.pedidoRepository.findAll();
	}
	
	public Pedido buscar(String codigo) {
		var pedidoOp=this.pedidoRepository.findByCodigo(codigo);
	    return pedidoOp.orElseThrow(()->new PedidoNaoEncontradoException(codigo) );
		
	}
	
	@Transactional
	public Pedido emitir(Pedido pedido) {
		
		var  cliente =new Usuario();
		cliente.setId(1l);
		pedido.setCliente(cliente);
		validarItens(pedido);
		validarPedido(pedido);
		pedido.definirFrete();
		pedido.calcularTotal();
		
		var pedidoSalvo=this.pedidoRepository.save(pedido);
		System.out.println(pedidoSalvo.getEnderecoEntrega());
		return pedidoSalvo;
		
	}
	
	private void validarPedido(Pedido pedido) {
		
	    
	    Cidade cidade = cidadeService.buscar(pedido.getEnderecoEntrega().getCidade().getId());
	    Usuario cliente = usuarioService.buscar(pedido.getCliente().getId());
	    Restaurante restaurante = restauranteService.buscar(pedido.getRestaurante().getId());
	    FormaPagamento formaPagamento = formaPagamentoService.buscarPor(pedido.getFormaPagamento().getId());

	    pedido.getEnderecoEntrega().setCidade(cidade);
	    pedido.setCliente(cliente);
	    pedido.setRestaurante(restaurante);
	    pedido.setFormaPagamento(formaPagamento);
	    
	    if (restaurante.naoAceitaFormaDePagamento(formaPagamento)) {
	        throw new NegocioException(String.format("Forma de pagamento '%s' não é aceita por esse restaurante.",
	                formaPagamento.getDescricao()));
	    }
	}

	private void validarItens(Pedido pedido) {
	    pedido.getItens().forEach(item -> {
	        Produto produto = produtoService.buscar(
	                pedido.getRestaurante().getId(), item.getProduto().getId());
	        
	        item.setPedido(pedido);
	        item.setProduto(produto);
	        item.setPrecoUnitario(produto.getPreco());
	    });
	
}
}
