package com.arthur.algafood.api.model.input;

import lombok.*;

import javax.validation.constraints.*;

@Setter
@Getter
public class UsuarioComSenhaInput extends UsuarioInput {

    @NotBlank
    private String senha;
}
