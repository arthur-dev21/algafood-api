package com.arthur.algafood.domain.repository;

import com.arthur.algafood.domain.model.*;
import com.arthur.algafood.infrastructure.repository.spec.*;
import org.springframework.stereotype.*;

@Repository
public interface PedidoRepository extends CustomJpaRepository<Pedido, Long> {

}