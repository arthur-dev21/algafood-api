package com.arthur.algafood.api.assembler.disassembler;

import com.arthur.algafood.api.model.input.*;
import com.arthur.algafood.domain.model.*;
import org.modelmapper.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Component
public class PedidoInputDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public Pedido toDomainObject(PedidoInput pedidoInput) {
        return modelMapper.map(pedidoInput, Pedido.class);
    }

    public void copyToDomainObject(PedidoInput pedidoInput, Pedido pedido) {
        modelMapper.map(pedidoInput, pedido);
    }
}
