package com.arthur.algafood.api.model;

import lombok.*;

import java.math.*;

@Setter
@Getter
public class ProdutoModel {

    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private Boolean ativo;
}
