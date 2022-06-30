package com.arthur.algafood.domain.repository;

import java.util.List;

import com.arthur.algafood.domain.model.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestauranteRepository extends JpaRepository<Restaurante,Long> {

	//List<Restaurante> listar();
	Restaurante buscar(Long id);
	Restaurante salvar(Restaurante restaurante);
	void remover(Restaurante restaurante);
	
}
