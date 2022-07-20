package com.arthur.algafood.api.controller;

import com.arthur.algafood.api.assembler.*;
import com.arthur.algafood.api.model.input.*;
import com.arthur.algafood.domain.model.*;
import com.arthur.algafood.domain.repository.*;
import com.arthur.algafood.domain.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private EmissaoPedidoService emissaoPedido;

    @Autowired
    private PedidoModelAssembler pedidoModelAssembler;

    @GetMapping
    public List<PedidoModel> listar() {
        List<Pedido> todosPedidos = pedidoRepository.findAll();

        return pedidoModelAssembler.toCollectionModel(todosPedidos);
    }

    @GetMapping("/{pedidoId}")
    public PedidoModel buscar(@PathVariable Long pedidoId) {
        Pedido pedido = emissaoPedido.buscarOuFalhar(pedidoId);

        return pedidoModelAssembler.toModel(pedido);
    }
}
