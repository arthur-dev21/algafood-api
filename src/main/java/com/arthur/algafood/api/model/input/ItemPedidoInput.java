package com.arthur.algafood.api.model.input;

import lombok.*;

import javax.validation.constraints.*;

@Setter
@Getter
public class ItemPedidoInput {

    @NotNull
    private Long produtoId;

    @NotNull
    @PositiveOrZero
    private Integer quantidade;

    private String observacao;
}
