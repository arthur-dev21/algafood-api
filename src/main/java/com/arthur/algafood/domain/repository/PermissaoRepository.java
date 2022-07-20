package com.arthur.algafood.domain.repository;

import java.util.List;

import com.arthur.algafood.domain.model.Permissao;
import org.springframework.data.jpa.repository.*;

public interface PermissaoRepository extends JpaRepository<Permissao , Long> {

	//List<Permissao> listar();
	//Permissao buscar(Long id);
	//Permissao salvar(Permissao permissao);
	//void remover(Permissao permissao);
	
}
