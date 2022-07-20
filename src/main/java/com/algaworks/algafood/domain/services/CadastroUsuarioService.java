package com.algaworks.algafood.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algafood.domain.exceptions.NegocioException;
import com.algaworks.algafood.domain.exceptions.UsuarioNaoEncontradoException;
import com.algaworks.algafood.domain.model.Usuario;
import com.algaworks.algafood.domain.repositories.UsuarioRepository;

@Service
public class CadastroUsuarioService {

	private static final String ENTIDADE_EM_USO="Grupo com código %s esta em uso e não pode ser removido";
	
	@Autowired
	private UsuarioRepository usuarioRep;
	
	@Transactional
	public Usuario salvar(Usuario usuario) {
       this.usuarioRep.detach(usuario);
	   var usuarioExistente=this.usuarioRep.findByEmail(usuario.getEmail());
		 
		
		 
	     if(usuarioExistente.isPresent() && !usuarioExistente.get().equals(usuario)) {
	    	
	    	 throw new NegocioException("Já existe um usuario cadastro com esse email");
	     }
	   
		return this.usuarioRep.save(usuario);
	}
	
	public List<Usuario> listar(){
		return this.usuarioRep.findAll();
	}
	
	public void excluir(Long id) {
		try {
		 this.usuarioRep.deleteById(id);
		}catch(EmptyResultDataAccessException ex) {
			throw new UsuarioNaoEncontradoException(id);
			
		}catch(DataIntegrityViolationException ex) {
            throw new NegocioException(String.format(ENTIDADE_EM_USO,id));		  	
		}
	}
	
	public Usuario buscar(Long id) {
		var usarioOpt=this.usuarioRep.findById(id);
		return usarioOpt.orElseThrow(()->new UsuarioNaoEncontradoException(id) );
	}
	

	 
	 @Transactional	
	  public void alterarSenha(Long id,String senhaAtual, String novaSenha) {
		 var usuario=buscar(id);
		 if(!usuario.senhaCoincideCom(senhaAtual)) {
			 throw new NegocioException("A senha atual informada não coincide com a senha cadastrada");
		 }
		 usuario.setSenha(novaSenha);
	  }	 
	
	
}
