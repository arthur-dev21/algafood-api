package com.arthur.algafood.domain.repository;

import java.util.List;

import com.arthur.algafood.domain.model.Cozinha;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CozinhaRepository extends JpaRepository<Cozinha,Long> {

	List<Cozinha> listar();
	Cozinha buscar(Long id);
	Cozinha salvar(Cozinha cozinha);
	void remover(Cozinha cozinha);
	
}
