package com.arthur.algafood.api.model.input;

import lombok.*;

import javax.validation.constraints.*;

@Setter
@Getter
public class UsuarioInput {

    @NotBlank
    private String nome;

    @NotBlank
    @Email
    private String email;
}
