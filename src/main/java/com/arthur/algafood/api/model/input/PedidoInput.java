package com.arthur.algafood.api.model.input;

import lombok.*;

import javax.validation.*;
import javax.validation.constraints.*;
import java.util.*;

@Setter
@Getter
public class PedidoInput {

    @Valid
    @NotNull
    private RestauranteIdInput restaurante;

    @Valid
    @NotNull
    private EnderecoInput enderecoEntrega;

    @Valid
    @NotNull
    private FormaPagamentoIdInput formaPagamento;

    @Valid
    @Size(min = 1)
    @NotNull
    private List<ItemPedidoInput> itens;

}
