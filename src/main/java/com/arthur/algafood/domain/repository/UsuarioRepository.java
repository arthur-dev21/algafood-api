package com.arthur.algafood.domain.repository;

import com.arthur.algafood.domain.model.*;
import com.arthur.algafood.infrastructure.repository.spec.*;

import org.springframework.stereotype.*;

import java.util.*;

@Repository
public interface UsuarioRepository extends CustomJpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);


}
