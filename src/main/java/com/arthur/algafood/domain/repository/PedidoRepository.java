package com.arthur.algafood.domain.repository;

import com.arthur.algafood.domain.model.*;
import com.arthur.algafood.infrastructure.repository.spec.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public interface PedidoRepository extends CustomJpaRepository<Pedido, Long> {

    Optional<Pedido> findByCodigo(String codigo);
    @Query("from Pedido p join fetch p.cliente join fetch p.restaurante r join fetch r.cozinha")
    List<Pedido> findAll();
}