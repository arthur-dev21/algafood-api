package com.arthur.algafood.api.model.input;

import lombok.*;

import javax.validation.constraints.*;
import java.math.*;

@Setter
@Getter
public class ProdutoInput {

    @NotBlank
    private String nome;

    @NotBlank
    private String descricao;

    @NotNull
    @PositiveOrZero
    private BigDecimal preco;

    @NotNull
    private Boolean ativo;

}
