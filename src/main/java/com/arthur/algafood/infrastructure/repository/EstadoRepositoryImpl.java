package com.arthur.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.arthur.algafood.domain.model.Estado;
import com.arthur.algafood.domain.repository.EstadoRepository;

@Component
public class EstadoRepositoryImpl  {

	@PersistenceContext
	private EntityManager manager;
	

	

	public Estado buscar(Long id) {
		return manager.find(Estado.class, id);
	}
	
	@Transactional

	public Estado salvar(Estado estado) {
		return manager.merge(estado);
	}
	
	@Transactional

	public void remover(Estado estado) {
		estado = buscar(estado.getId());
		manager.remove(estado);
	}

}
