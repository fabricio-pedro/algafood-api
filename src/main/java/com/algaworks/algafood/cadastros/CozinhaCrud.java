package com.algaworks.algafood.cadastros;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algafood.domain.model.Cozinha;

@Component
public class CozinhaCrud {

 @PersistenceContext	
 private EntityManager entityManager;
 
 public List<Cozinha> listAll(){
	 TypedQuery<Cozinha> query = entityManager.createQuery("from Cozinha", Cozinha.class);
	 return query.getResultList();
 }
 @Transactional
 public void incluir(Cozinha cozinha) {
	this.entityManager.merge(cozinha);
 }
 
 public Cozinha buscar(Long id) {
	 return this.entityManager.find(Cozinha.class, id);
 }
 
	
	
	
}
