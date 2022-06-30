package com.arthur.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.arthur.algafood.domain.model.Cidade;
import com.arthur.algafood.domain.repository.CidadeRepository;

@Component
public class CidadeRepositoryImpl  {

	@PersistenceContext
	private EntityManager manager;
	


	

	public Cidade buscar(Long id) {
		return manager.find(Cidade.class, id);
	}
	
	@Transactional

	public Cidade salvar(Cidade cidade) {
		return manager.merge(cidade);
	}
	
	@Transactional

	public void remover(Cidade cidade) {
		cidade = buscar(cidade.getId());
		manager.remove(cidade);
		
	}

}
