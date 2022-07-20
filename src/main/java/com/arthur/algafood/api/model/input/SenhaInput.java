package com.arthur.algafood.api.model.input;

import lombok.*;

import javax.validation.constraints.*;

@Setter
@Getter
public class SenhaInput {

    @NotBlank
    private String senhaAtual;

    @NotBlank
    private String novaSenha;
}