package com.arthur.algafood.api.model.input;

import lombok.*;

import javax.validation.constraints.*;

@Getter
@Setter
public class CidadeIdInput {

    @NotNull
    private Long id;
}
