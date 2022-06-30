package com.arthur.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.arthur.algafood.domain.model.Cozinha;
import com.arthur.algafood.domain.repository.CozinhaRepository;



@Component
public class CozinhaRepositoryImpl  {

	@PersistenceContext
	private EntityManager manager;
	

	public List<Cozinha> listar() {
		return manager.createQuery("from Cozinha", Cozinha.class)
				.getResultList();
	}
	

	public Cozinha buscar(Long id) {
		return manager.find(Cozinha.class, id);
	}
	
	@Transactional
	
	public Cozinha salvar(Cozinha cozinha) {
		return manager.merge(cozinha);
	}
	
	@Transactional

	public void remover(Cozinha cozinha) {
		cozinha = buscar(cozinha.getId());
		manager.remove(cozinha);
	}

}
