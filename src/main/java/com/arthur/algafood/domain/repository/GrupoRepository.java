package com.arthur.algafood.domain.repository;

import com.arthur.algafood.domain.model.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface GrupoRepository extends JpaRepository<Grupo, Long> {

}
