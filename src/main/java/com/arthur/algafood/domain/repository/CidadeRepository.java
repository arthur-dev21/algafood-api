package com.arthur.algafood.domain.repository;

import java.util.List;

import com.arthur.algafood.domain.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade,Long> {

	//List<Cidade> listar();
	Cidade buscar(Long id);
	Cidade salvar(Cidade cidade);
	void remover(Cidade cidade);
	
}
