package com.arthur.algafood.api.model;

import lombok.*;

import java.math.*;

@Getter
@Setter
public class ItemPedidoModel {

    private Long produtoId;
    private String produtoNome;
    private Integer quantidade;
    private BigDecimal precoUnitario;
    private BigDecimal precoTotal;
    private String observacao;
}
