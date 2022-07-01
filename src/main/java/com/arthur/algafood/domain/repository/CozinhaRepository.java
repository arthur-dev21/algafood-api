package com.arthur.algafood.domain.repository;

import java.util.List;
import java.util.Optional;

import com.arthur.algafood.domain.model.Cozinha;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CozinhaRepository extends JpaRepository<Cozinha,Long> {

        //tras a lista por nome
        List<Cozinha>findQualquerCoisaByNome(String nome);

        //tras uma cozinha em formato de optional pra evitar o nullpointexcption
         Optional<Cozinha> findByNome(String cozinha);

         //like em sql

	
}
