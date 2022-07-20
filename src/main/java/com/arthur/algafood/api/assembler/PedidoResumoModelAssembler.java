package com.arthur.algafood.api.assembler;

import com.arthur.algafood.api.model.*;
import com.arthur.algafood.api.model.input.*;
import com.arthur.algafood.domain.model.*;
import org.modelmapper.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;
import java.util.stream.*;

@Component
public class PedidoResumoModelAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public PedidoResumoModel toModel(Pedido pedido) {
        return modelMapper.map(pedido, PedidoResumoModel.class);
    }

    public List<PedidoResumoModel> toCollectionModel(List<Pedido> pedidos) {
        return pedidos.stream()
                .map(pedido -> toModel(pedido))
                .collect(Collectors.toList());
    }

}
